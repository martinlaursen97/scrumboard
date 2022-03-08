package com.company.storyboard.service;

import com.company.storyboard.model.Board;
import com.company.storyboard.model.Task;
import com.company.storyboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Board getBoardById(long id) {
        Optional<Board> boardOptional = boardRepository.findById(id);
        List<Task> t = boardOptional.get().getPillars().get(0).getTasks();

        for (Task tt : t) {
            System.out.println(tt.getPillar().getPillarId());
        }
        return boardOptional.orElse(null);
    }
}
