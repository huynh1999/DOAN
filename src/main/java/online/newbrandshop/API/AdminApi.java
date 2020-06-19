package online.newbrandshop.API;

import online.newbrandshop.modal.CategoryEntity;
import online.newbrandshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/api/")
public class AdminApi {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/getCategory")
    public String GetCategory()
    {
        List<CategoryEntity>categoryEntities=categoryRepository.findAll();
        StringBuilder rebody= new StringBuilder();
        for (CategoryEntity categoryEntity : categoryEntities) {
            rebody.append("|" + categoryEntity.getCategoryName());
        }
        return rebody.toString();
    }
}
