package com.blog_app_api.service.impl.UserServiceImpl;

import com.blog_app_api.Repository.CategoryRepository;
import com.blog_app_api.entity.Category;
import com.blog_app_api.exceptions.ResourceNotFoundException;
import com.blog_app_api.payload.CategoryDTO;
import com.blog_app_api.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryImpl implements CategoryService {



    private final CategoryRepository categoryRepository;


    private final ModelMapper modelMapper;

    @Autowired
    CategoryImpl(CategoryRepository categoryRepository, ModelMapper modelMapper){
        this.categoryRepository=categoryRepository;
        this.modelMapper=modelMapper;
    }


    //for getting all user
    @Override
    public List<CategoryDTO> getAllCategory() {
                  List<Category> allCategoryList= categoryRepository.findAll();
                 List<CategoryDTO> allcategoryDtoList= allCategoryList.stream().map(category -> categoryToCategoryDTO(category)).collect(Collectors.toList());
        return allcategoryDtoList;
    }

    // for getting single User
    @Override
    public CategoryDTO getCategoryById(Integer categoryId) {
        Category categoryData = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("this category", "Id", categoryId));
        CategoryDTO categoryDTOData = categoryToCategoryDTO(categoryData);
        return categoryDTOData;
    }

    // for creating the user
    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDto) {
       Category createdCategory = categorDTOtoCategory(categoryDto);
       Category savedCategory= categoryRepository.save(createdCategory);
        return categoryToCategoryDTO(savedCategory);
    }

    @Override
    public CategoryDTO modifyCategoryData(CategoryDTO categoryDto, Integer categoryId) {
    Category categorydata=categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));
    categorydata.setCategoryDescription(categoryDto.getCategoryDescription());
    categorydata.setCategoryTitle(categoryDto.getCategoryTitle());
    categoryRepository.save(categorydata);
    return categoryToCategoryDTO(categorydata);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category categoryData = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("this category", "Id", categoryId));
        categoryRepository.delete(categoryData);
    }

   private   Category  categorDTOtoCategory( CategoryDTO categoryDto){
       Category categoryData = this.modelMapper.map(categoryDto, Category.class);
        return categoryData;
   }

   private   CategoryDTO categoryToCategoryDTO (Category category){
        CategoryDTO categoryDTOData= this.modelMapper.map(category,CategoryDTO.class);
        return categoryDTOData;
   }





}
