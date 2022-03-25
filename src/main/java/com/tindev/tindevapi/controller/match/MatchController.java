package com.tindev.tindevapi.controller.match;

import com.tindev.tindevapi.dto.match.MatchDTO;
import com.tindev.tindevapi.service.MatchService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
@Api(value = "5 - Match API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"5 - Match API"}, description = "Match Controls")
public class MatchController{


    @Autowired
    private MatchService matchService;


    @GetMapping
    public ResponseEntity<List<MatchDTO>> list() {
        return ResponseEntity.ok(matchService.list());
    }

    @PostMapping("/{userId1}/{userId2}")
    public ResponseEntity<MatchDTO> addMatch(@RequestParam("userId1") Integer userId1, @RequestParam("userId2") Integer userId2) throws Exception {
        return ResponseEntity.ok(matchService.addMatch(userId1, userId2));
    }


//
//    @GetMapping("/{userId}")
//    public ResponseEntity<List<MatchDTO>> listMatchesOfTheUser(@PathVariable("userId") Integer userId){
//        return ResponseEntity.ok(matchService.listMatchesOfTheUser(userId));
//    }
//

//
//    @DeleteMapping("/{matchId}")
//    public ResponseEntity<String> deleteMatch(@PathVariable("matchId") Integer matchId) throws Exception {
//        matchService.deleteMatch(matchId);
//        return ResponseEntity.ok("Match Deletado!");
//    }

}
