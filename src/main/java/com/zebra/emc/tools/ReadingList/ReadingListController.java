package com.zebra.emc.tools.ReadingList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Controller: In order to be picked up by component-scanning and automatically be registered as a
 * bean in Spring application context.
 * @ReqyestMapping: Map all of its handler methods to a base URL path of "/".
 */
@Controller
@RequestMapping("/")
public class ReadingListController {

    private ReadingListRepository readingListRepository;
    private AmazonProperties amazonProperties;

    /*
     * Auto inject and configure beans
     */
    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository, AmazonProperties
        amazonProperties) {
        this.readingListRepository = readingListRepository;
        this.amazonProperties = amazonProperties;
    }

    /*
     * Handles HTTP GET requests for /{reader} by retrieving a Book list from repo. It puts the
     * list of Book into the model under the key "books" and return "readingList" as the logical
     * name of the view to render the model
     */
    @RequestMapping(method = RequestMethod.GET)
    public String readersBooks(Reader reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader.getUsername());
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
            model.addAttribute("amazonID", amazonProperties.getAssociateId());
        }
        return "readingList"; // Logical view name
    }

    /*
     * Handles HTTP POST request for /{reader}, binding the data in the body of the request to a
     * Book object. It sets the Book object's reader property to the reader's name, and then
     * saves the modified Book via the repository's save() method. Finally, it returns by
     * specifying a redirect to /{reader} (which will be handled by the other controller method).
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/";
    }
}
