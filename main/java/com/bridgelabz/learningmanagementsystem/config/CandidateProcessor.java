package com.bridgelabz.learningmanagementsystem.config;

import com.bridgelabz.learningmanagementsystem.model.CandidateModel;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDateTime;

public class CandidateProcessor implements ItemProcessor<CandidateModel,CandidateModel> {
    @Override
    public CandidateModel process(CandidateModel candidateModel) throws Exception {
        if (candidateModel.getCicId() != null){
            candidateModel.setCreatedStamp(LocalDateTime.now());
            return candidateModel;
        }else {
            return null;
        }
    }
}
