package online.newbrandshop.controller.admin;

import online.newbrandshop.modal.ImageEntity;
import online.newbrandshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller(value="controllerForAdmin")
public class HomeController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProfileUserRepository profileUserRepository;
    @Autowired
    RoleUserRepository roleUserRepository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    ProductRepository productRepository;
    @RequestMapping("/uploadImage")
    ModelAndView uploadImage()
    {
        ModelAndView mav=new ModelAndView("web/UploadImage");
        return mav;
    }
    @RequestMapping(value = "/savefile",method = RequestMethod.POST)
    public String savefile(@RequestParam CommonsMultipartFile file, HttpSession session) throws FileNotFoundException {
        String path = session.getServletContext().getRealPath("/template/img");
        String filename = file.getOriginalFilename();

        System.out.println(path + " " + filename);
        try {
            byte barr[] = file.getBytes();

            BufferedOutputStream bout = new BufferedOutputStream(
                    new FileOutputStream(path + "/" + filename));
            bout.write(barr);
            bout.flush();
            bout.close();
            ImageEntity imageEntity=new ImageEntity();
            imageEntity.setLink("/template/img/"+filename);
            imageRepository.save(imageEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "web/UploadImage";
    }
    @RequestMapping("/uploadedImage")
    ModelAndView uploadedImage()
    {
        ModelAndView mav=new ModelAndView("/web/UploadedImage");
        List<ImageEntity> imageEntities=imageRepository.findAll();
        mav.addObject("test","huynh");
        mav.addObject("list",imageEntities);
        return mav;
    }
}
