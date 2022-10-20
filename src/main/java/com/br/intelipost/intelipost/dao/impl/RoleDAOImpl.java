package com.br.intelipost.intelipost.dao.impl;

import com.br.intelipost.intelipost.dao.RoleDAO;
import com.br.intelipost.intelipost.model.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Samuel Catalano
 */

@Slf4j
@RequiredArgsConstructor
@Repository
@Transactional
public class RoleDAOImpl extends BaseDAOImpl<Role> implements RoleDAO{
}