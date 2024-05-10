package com.mall.api.repository;

import com.mall.api.domain.Todo;
import java.time.LocalDate;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            Todo todo = Todo.builder()
                    .title("Title...." + i)
                    .dueDate(LocalDate.of(2024, 12, 31))
                    .writer("user00")
                    .build();

            todoRepository.save(todo);

        }
    }

    @Test
    public void testRead() {
        //존재하는 번호로 확인
        Long tno = 33L;
        
    }
}
