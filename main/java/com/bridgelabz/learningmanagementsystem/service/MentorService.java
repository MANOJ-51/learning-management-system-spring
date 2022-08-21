package com.bridgelabz.learningmanagementsystem.service;

import com.bridgelabz.learningmanagementsystem.dto.MentorDTO;
import com.bridgelabz.learningmanagementsystem.exception.CustomExceptions;
import com.bridgelabz.learningmanagementsystem.model.AdminModel;
import com.bridgelabz.learningmanagementsystem.model.MentorModel;
import com.bridgelabz.learningmanagementsystem.repository.IAdminRepository;
import com.bridgelabz.learningmanagementsystem.repository.IMentorRepository;
import com.bridgelabz.learningmanagementsystem.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MentorService implements IMentorService {
    @Autowired
    IMentorRepository iMentorRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    IAdminRepository iAdminRepository;

    @Override
    public MentorModel addMentor(String token, MentorDTO mentorDTO) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            MentorModel mentorModel = new MentorModel(mentorDTO);
            mentorModel.setCreatedDate(LocalDateTime.now());
            iMentorRepository.save(mentorModel);
            return mentorModel;
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public MentorModel editMentor(String token, Long id, MentorDTO mentorDTO) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            Optional<MentorModel> isMentorPresent = iMentorRepository.findById(id);
            if (isMentorPresent.isPresent()){
                isMentorPresent.get().setEmployeeId(mentorDTO.getEmployeeId());
                isMentorPresent.get().setFirstName(mentorDTO.getFirstName());
                isMentorPresent.get().setLastName(mentorDTO.getLastName());
                isMentorPresent.get().setMentorType(mentorDTO.getMentorType());
                isMentorPresent.get().setMentorRole(mentorDTO.getMentorRole());
                isMentorPresent.get().setMobileNumber(mentorDTO.getMobileNumber());
                isMentorPresent.get().setEmailId(mentorDTO.getEmailId());
                isMentorPresent.get().setYearsOfExperience(mentorDTO.getYearsOfExperience());
                isMentorPresent.get().setPreferredTime(mentorDTO.getPreferredTime());
                isMentorPresent.get().setStartDate(mentorDTO.getStartDate());
                isMentorPresent.get().setStatus(mentorDTO.getStatus());
                isMentorPresent.get().setMentorDescription(mentorDTO.getMentorDescription());
                isMentorPresent.get().setCreatorUser(mentorDTO.getCreatorUser());
                isMentorPresent.get().setSupervisorId(mentorDTO.getSupervisorId());
                isMentorPresent.get().setUpdatedDate(LocalDateTime.now());
                iMentorRepository.save(isMentorPresent.get());
                return isMentorPresent.get();
            }
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public List<MentorModel> viewList(String token) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminIdPresent = iAdminRepository.findById(adminId);
        if (isAdminIdPresent.isPresent()){
            List<MentorModel> getList = iMentorRepository.findAll();
            if (getList.size()>0){
                return getList;
            }
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public MentorModel removeMentor(String token, Long id) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            Optional<MentorModel> isMentorPresent = iMentorRepository.findById(id);
            if (isMentorPresent.isPresent()){
                iMentorRepository.delete(isMentorPresent.get());
                return isMentorPresent.get();
            }
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public MentorModel addPath(String token, Long id, String profilePath) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            Optional<MentorModel> isMentorPresent = iMentorRepository.findById(id);
            isMentorPresent.get().setProfilePath(profilePath);
            iMentorRepository.save(isMentorPresent.get());
            return isMentorPresent.get();
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public MentorModel getListId(String token, Long id) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            return iMentorRepository.getMentorModelById(id);
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public Long getCountByType(String token, String userChoice) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            return iMentorRepository.countByMentorType(userChoice);
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

}
