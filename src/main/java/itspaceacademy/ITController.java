package itspaceacademy;

import com.google.zxing.WriterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.Base64;

@Controller
public class ITController {

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/IT.png";


    @GetMapping("/")
    public String getQRCode(ModelMap map){

        String facebook="https://www.facebook.com/ITSpaceAcademy";


        byte[] image = new byte[0];
        try {

            // Ստեղծել և վերադարձնել Qr կոդը բայթերի զանգվածում(մասիվում)
            QRCodeGenerator.generateQRCodeImage(facebook,250,250,QR_CODE_IMAGE_PATH);

        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        // Փոխակերպել բայթերի զանգվածը (մասիվում) Base64 կոդավորման տողի
        String qrcode = Base64.getEncoder().encodeToString(image);


       // model.addAttribute("qrcode",qrcode);
        map.addAttribute("qrcode",facebook);

        return "qrcode";
    }

}
