package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.BadgeDTO;
import miu.edu.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/badges")
@RequiredArgsConstructor
public class BadgeController {

    @Autowired
    private final BadgeService badgeService;

    @GetMapping
    public ResponseEntity<?> getAllBadges(){
        return new ResponseEntity<List< BadgeDTO >>(badgeService.findAllBadges(), HttpStatus.OK);
    }
    @GetMapping("/{badge_id}")
    public ResponseEntity<?> getBadgeById(@PathVariable long badge_id){
        return new ResponseEntity< BadgeDTO >(badgeService.findBadgeById(badge_id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addBadge(@RequestBody BadgeDTO badgeDTO){
        badgeService.addBadge(badgeDTO);
        return new ResponseEntity<String>("Badge Saved successfully.", HttpStatus.OK);
    }
    @PutMapping("/{badge_id}")
    public ResponseEntity<?> updateBadge(@PathVariable long badge_id, @RequestBody BadgeDTO badgeDTO){
        badgeService.updateBadge(badge_id, badgeDTO);
        return new ResponseEntity<String>("Badge Updated successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/{badge_id}")
    public ResponseEntity<?> deleteBadge(@PathVariable long badge_id){
        badgeService.MakeBadgeInactive(badge_id);
        return new ResponseEntity<String>("Badge Deleted successfully.", HttpStatus.OK);
    }

}
