package com.azure.LoggedInn.controllers;

import com.azure.LoggedInn.dto.EmailDTO;
import com.azure.LoggedInn.dto.HostDTO;
import com.azure.LoggedInn.mappers.HostMapper;
import com.azure.LoggedInn.models.Host;
import com.azure.LoggedInn.service.HostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/host")
@RequiredArgsConstructor
public class HostController {

     private final HostService hostService;
     private final HostMapper hostMapper;

     @GetMapping
     @ResponseBody
     @ResponseStatus(code = HttpStatus.OK)
     public List<Host> getHosts(){

          return hostService.getAll();
     }

     @GetMapping(params ="id")
     @ResponseBody
     @ResponseStatus(code = HttpStatus.OK)
     public Host getHostById(@RequestParam("id") long id){
          return hostService.getUserById(id);
     }

     @PostMapping("/register")
     @ResponseBody
     @ResponseStatus(code = HttpStatus.CREATED)
     public Host createHost(@RequestBody @Valid HostDTO hostDTO){
          Host host = hostMapper.DTOtoHost(hostDTO);

          return this.hostService.saveHost(host);
     }


     @PutMapping(value = "/update",params = "id")
     @ResponseBody
     @ResponseStatus(code = HttpStatus.OK)
     public Host updateHost(@RequestParam("id") long id, @RequestBody @Valid   HostDTO newHostDTO){
          Host newHost = hostMapper.DTOtoHost(newHostDTO);

          return this.hostService.updateHost(id, newHost);
     }

     //This might not be needed...
     @PutMapping(value = "/update")
     @ResponseStatus(code = HttpStatus.OK)
     public void updateHostEmail(@RequestBody @Valid EmailDTO emailDTO){
          this.hostService.updateHostEmail(emailDTO.getOldEmail(), emailDTO.getNewEmail());
     }

     @DeleteMapping(value = "/delete", params = "id")
     @ResponseStatus(code = HttpStatus.OK )
     public void deleteHostById(@RequestParam("id") long id){
          this.hostService.deleteHost(id);
     }

     @DeleteMapping(value = "/delete")
     @ResponseStatus(code = HttpStatus.OK)
     public void deleteHost(@RequestBody @Valid  HostDTO hostDTO){
          Host host = hostMapper.DTOtoHost(hostDTO);
          this.hostService.deleteHost(host);
     }

}
