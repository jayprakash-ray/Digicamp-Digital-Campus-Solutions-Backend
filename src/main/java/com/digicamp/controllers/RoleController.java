package com.digicamp.controllers;

import com.digicamp.entity.Role;
import com.digicamp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("")
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }

    @GetMapping("")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/{roleName}")
    public Role getRole(@PathVariable String roleName){
        return roleService.getRoleByName(roleName);
    }

    @DeleteMapping("/{id}")
    private void deleteRole(@PathVariable("id") int id)
    {
        roleService.deleteRole(id);
        //System.out.println("Deleted");
    }

    @PutMapping("/{id}")
    private Role update(@RequestBody Role role,@PathVariable int id)
    {
        role.setRoleId(id);
        return roleService.updateRole(role);

    }

}
