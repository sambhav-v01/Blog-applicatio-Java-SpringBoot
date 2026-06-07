package com.blog_app_api.controller;

import com.blog_app_api.payload.CategoryDTO;
import com.blog_app_api.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

   private CategoryService categoryService;

    CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }


    //getAllCategory
    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllData(){
    List<CategoryDTO> categoryDTOList =categoryService.getAllCategory();
    return  ResponseEntity.ok(categoryDTOList);
    }




    //getoneCategory
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryData(@PathVariable Integer id){
       CategoryDTO categoryDTO= categoryService.getCategoryById(id);
       return ResponseEntity.ok(categoryDTO);
    }






    //creatCategory
    @PostMapping("/")
        public ResponseEntity<CategoryDTO> cteateCategory(@Valid @RequestBody CategoryDTO categoryDTO){
                    CategoryDTO createddCategoryDTO= categoryService.createCategory(categoryDTO);
                 return new ResponseEntity<CategoryDTO>(createddCategoryDTO, HttpStatus.CREATED);

        }




    //updateCategory
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid  @RequestBody CategoryDTO categoryDTO, @PathVariable Integer id){
            CategoryDTO categoryUpadeted=categoryService.modifyCategoryData(categoryDTO,id);
            return ResponseEntity.ok(categoryUpadeted);

    }


    //deletCategory
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(Map.of("message","User deleted Successfuly"), HttpStatus.OK);
    }



}
