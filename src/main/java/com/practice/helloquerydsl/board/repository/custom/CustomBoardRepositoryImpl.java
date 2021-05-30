package com.practice.helloquerydsl.board.repository.custom;

import com.practice.helloquerydsl.board.entity.Board;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import static com.practice.helloquerydsl.board.entity.QBoard.board;

@Repository
@AllArgsConstructor
public class CustomBoardRepositoryImpl implements CustomBoardRepository{
    private final JPAQueryFactory query;

    @Override
    public List<Board> getBoardsDynamically(Board param, Pageable pageable, LocalDateTime from, LocalDateTime to) {
        BooleanBuilder booleanBuilder = getBoardsDynamicallyWhere(param, from, to);

        return query.select(Projections.fields(Board.class
                                                , board.id
                                                , board.title
                                                , board.content
                                                , board.articleType
                                                , board.user
                                                , board.boardComments
                                                , board.deleteAt
                                                , board.registDateTime
                                                , board.updateDateTime)).from(board)
                                                                        .where(booleanBuilder)
                                                                        .offset(pageable.getOffset())
                                                                        .limit(pageable.getPageSize())
                                                                        .fetch();
    }

    private BooleanBuilder getBoardsDynamicallyWhere(Board param, LocalDateTime from, LocalDateTime to){
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if(StringUtils.hasLength(param.getTitle())){
            booleanBuilder.and(board.title.contains(param.getTitle()));
        }
        if(StringUtils.hasLength(param.getContent())){
            booleanBuilder.and(board.content.contains(param.getContent()));
        }
        if(StringUtils.hasLength(param.getUser().getNickname())){
            booleanBuilder.and(board.user.nickname.eq(param.getUser().getNickname()));
        }
        if(from!=null && to==null){
            booleanBuilder.and(board.registDateTime.after(from));
        }else if(from==null && to!=null){
            booleanBuilder.and(board.registDateTime.before(to));
        }else if(from!=null && to!=null){
            booleanBuilder.and(board.registDateTime.between(from, to));
        }

        return booleanBuilder;
    }
}
