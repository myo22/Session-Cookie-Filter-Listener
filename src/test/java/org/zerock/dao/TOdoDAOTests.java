package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.review2.dao.TodoDAO;
import org.zerock.review2.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TOdoDAOTests {

    private TodoDAO todoDAO;

    @BeforeEach //본 어노테이션을 붙인 메서드는 테스트 메서드 실행 이전에 수행된다
    public void ready(){
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception{

        System.out.println(todoDAO.getTime() );
    }

    @Test
    public void testInsert() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2021,12,31))
                .build();

        todoDAO.insert(todoVO);
    }

    @Test
    public void testList() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception{

        Long tno = 1L; //반드시 존재하는 번호를 이용

        TodoVO vo = todoDAO.selectOne(tno);

        System.out.println(vo);
    }

    @Test
    public void testdeleteOnd() throws Exception{
        todoDAO.deleteOne(5L);
    }

    @Test
    public void testUpdatedOne() throws  Exception {
        TodoVO todoVO = TodoVO.builder()
                .tno(1L)
                .title("birthday")
                .dueDate(LocalDate.of(2023,1,25))
                .finished(true)
                .build();

        todoDAO.updateOne(todoVO);
    }
}
