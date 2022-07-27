package com.maiqu.counsel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maiqu.counsel.entity.Psychologist;
import com.maiqu.counsel.mapper.PsychologistMapper;
import com.maiqu.counsel.service.PsyChologistService;
import org.springframework.stereotype.Service;

@Service
public class PsyChologistServiceImpl extends ServiceImpl<PsychologistMapper, Psychologist> implements PsyChologistService {
}
