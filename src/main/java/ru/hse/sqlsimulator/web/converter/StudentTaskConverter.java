package ru.hse.sqlsimulator.web.converter;

import org.springframework.stereotype.Component;
import ru.hse.sqlsimulator.model.StudentTask;
import ru.hse.sqlsimulator.web.dto.StudentTaskDTO;

import java.util.Random;

/**
 * Created by Anna on 11/7/2015.
 */
@Component
public class StudentTaskConverter {

    private Random random = new Random();

    public StudentTask toTaskForPair(StudentTaskDTO dto) {
        StudentTask task = new StudentTask();

        task.setId(random.nextInt());
        task.setName(dto.getName());
        task.setTaskText(dto.getTaskText());
        task.setActive(false);
        task.setPlanned(false);

        return task;
    }
}
