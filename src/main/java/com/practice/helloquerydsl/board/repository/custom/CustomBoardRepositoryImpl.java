package com.practice.helloquerydsl.board.repository.custom;

import com.practice.helloquerydsl.board.entity.Board;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
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
        //BooleanBuilder 사용 로직
        /*BooleanBuilder booleanBuilder = getBoardsDynamicallyWhere(param, from, to);

        return query.select(Projections.fields(Board.class
                                                , board.id
                                                , board.title
                                                , board.content
                                                , board.articleType
                                                , board.user
                                                , board.boardComments
                                                , board.deleteAt
                                                , board.registDateTime
                                                , board.updateDateTime))
                    .from(board)
                    .where(booleanBuilder)
                    .offset(pageable.getOffset())
                    .limit(pageable.getPageSize())
                    .fetch();*/

        //------------------------------------

        //BooleanExpression 사용 로직
        return query.selectFrom(board)
                    .where(containsTitle(param.getTitle())
                            , containsContent(param.getContent())
                            //, eqNickname(param.getUser().getNickname())
                            , betweenRegistDateTime(from, to))
                    .offset(pageable.getOffset())
                    .limit(pageable.getPageSize())
                    .fetch();
    }

    //Deprecated! BooleanExpression 활용 권장
    private BooleanBuilder getBoardsDynamicallyWhere(Board param, LocalDateTime from, LocalDateTime to){
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        //contains title
        if(StringUtils.hasText(param.getTitle())){
            booleanBuilder.and(board.title.contains(param.getTitle()));
        }

        //contains content
        if(StringUtils.hasText(param.getContent())){
            booleanBuilder.and(board.content.contains(param.getContent()));
        }

        //eq nickname
        if(StringUtils.hasText(param.getUser().getNickname())){
            booleanBuilder.and(board.user.nickname.eq(param.getUser().getNickname()));
        }

        //after, before or between date
        if(from!=null && to==null){
            booleanBuilder.and(board.registDateTime.after(from));
        }else if(from==null && to!=null){
            booleanBuilder.and(board.registDateTime.before(to));
        }else if(from!=null && to!=null){
            booleanBuilder.and(board.registDateTime.between(from, to));
        }

        return booleanBuilder;
    }

    private BooleanExpression containsTitle(String title){
        return StringUtils.hasText(title) ? board.title.contains(title) : null;
    }

    private BooleanExpression containsContent(String content){
        return StringUtils.hasText(content) ? board.content.contains(content) : null;
    }

    private BooleanExpression eqNickname(String nickname){
        return StringUtils.hasText(nickname) ? board.user.nickname.eq(nickname) : null;
    }

    private BooleanExpression betweenRegistDateTime(LocalDateTime from, LocalDateTime to){
        if(from==null && to==null){
            return null;
        }else if(from!=null && to==null){
            return board.registDateTime.after(from);
        }else if(from==null && to!=null){
            return board.registDateTime.before(to);
        }else {
            return board.registDateTime.between(from, to);
        }
    }
}
