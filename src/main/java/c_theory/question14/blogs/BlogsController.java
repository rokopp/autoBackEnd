package c_theory.question14.blogs;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogsController {

    //todo for question 14 there are 4 assignments in total
    // Each person has to do only 1. So 2 person team has to do 2 different ones, 3 person - 3, 4 person - 4.
    // Make sure to commit under your user otherwise points won't count.
    // I didn't number these so you can pick your favorite

    //todo
    // You are creating a rest controller for blogs. Think blog aggregator or blog collection.
    // You need to add necessary annotations and methods to this class.
    // This class should compile.
    // It should run successfully when moved to your application package.
    // Method body is not important and will not be graded.
    // Modifying other classes is unnecessary and will not be graded.

    //todo A add necessary annotations on the class

    //todo B create a method to query blogs (plural)
    @GetMapping
    public List<Blog> getAllBlogs(
            @RequestParam(defaultValue = "1") long page,
            @RequestParam(defaultValue = "20") long size,
            @RequestParam(defaultValue = "popularFirst") String sortingMethod
    ) {
        //return blogService.getAllBlogs(page, size, sortingMethod)
        return null;
    }

    //todo C create a method to query single blog
    
    @GetMapping({"id"})
    public Blog getBlog(@PathVariable String id) {
        // return blogService.findById(id)
        return null;
    } 

    //todo D create a method to save a new blog
    
    @PostMapping
    public Blog saveBlog(@RequestBody Blog blog) {
        return null;
    }

    //todo E create a method to update a blog

    @PutMapping("{id}")
    public void updateBlog(@RequestBody Blog blog, @PathVariable String id) {
        //blogService.updateBlog(id, blog);
    }


    //todo F create a method to delete a blog

    @DeleteMapping("{id}")
    public String deleteBlog(@PathVariable String id) {
        //blogService.deleteById(id)
        return "Deleted";
    }

    //todo G assuming each blog has only 1 author (one-to-one relation) create a method to query blog's author

    @GetMapping("{id}/{authorDisplayName}")
    public Author getBlogAuthor(@PathVariable long id,
                                @PathVariable String authorDisplayName){
        //return blogService.findById(id).getAuthor();
        return null;
    }

    //todo H create a method to update blog url (and nothing else)

    @PutMapping("{id}/{url}")
    public Blog updateUrl(@PathVariable String id, @PathVariable String url) {
        //blogService.updateUrl(id, url);
        return null;
    }

    //todo I-J modify correct method to support pagination, pagination is done by page and size
    //todo I add page (pagination starts at page 1)
    //todo J add size (default page size is 20)

    //todo K modify correct method to order blogs
    // * by most recent first
    // * by least recent first
    // (you can assume that by default it searches by most popular first)

}
