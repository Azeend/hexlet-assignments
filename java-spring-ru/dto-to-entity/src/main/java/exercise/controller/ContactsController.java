package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import exercise.model.Contact;
import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO create(@RequestBody ContactCreateDTO contactData) {
        var contactEntity = new Contact();
        contactEntity.setFirstName(contactData.getFirstName());
        contactEntity.setLastName(contactData.getLastName());
        contactEntity.setPhone(contactData.getPhone());
        contactRepository.save(contactEntity);
        var contactDTO = new ContactDTO();
        contactDTO.setId(contactEntity.getId());
        contactDTO.setFirstName(contactEntity.getFirstName());
        contactDTO.setLastName(contactEntity.getLastName());
        contactDTO.setPhone(contactEntity.getPhone());
        contactDTO.setCreatedAt(contactEntity.getCreatedAt());
        contactDTO.setUpdatedAt(contactEntity.getUpdatedAt());
        return contactDTO;
    }
    // END
}
