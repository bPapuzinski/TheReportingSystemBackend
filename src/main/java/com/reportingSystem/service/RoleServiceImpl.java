package com.reportingSystem.service;

import com.reportingSystem.dto.RoleDto;
import com.reportingSystem.mapper.DefaultMapper;
import com.reportingSystem.repository.RoleRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    private MapperFacade mapper = new DefaultMapper();

    @Override
    public List<RoleDto> getListOfRoles() {
        return roleRepository.findAll().stream().map(role -> mapper.map(role, RoleDto.class)).collect(Collectors.toList());
    }
}
