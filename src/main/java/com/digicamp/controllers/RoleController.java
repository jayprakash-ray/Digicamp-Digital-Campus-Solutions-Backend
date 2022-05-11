package com.digicamp.controllers;

import com.digicamp.entity.Role;
import com.digicamp.service.RoleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    private static final Logger logger = LogManager.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @PostMapping("")
    public Role createRole(@RequestBody Role role){
        logger.info("createRole called!");
        return roleService.createRole(role);
    }

    @GetMapping("")
    public List<Role> getAllRoles(){
        logger.info("getAllRoles called!");
        return roleService.getAllRoles();
    }

    @GetMapping("/{roleName}")
    public Role getRole(@PathVariable String roleName){
        logger.info("getRole called!");
        return roleService.getRoleByName(roleName);
    }

    @DeleteMapping("/{id}")
    private void deleteRole(@PathVariable("id") int id)
    {
        logger.info("deleteRole called!");
        roleService.deleteRole(id);
        //System.out.println("Deleted");
    }

    @PutMapping("/{id}")
    private Role updateRole(@RequestBody Role role,@PathVariable int id)
    {
        logger.info("updateRole called!");
        role.setRoleId(id);
        return roleService.updateRole(role);
    }

}
