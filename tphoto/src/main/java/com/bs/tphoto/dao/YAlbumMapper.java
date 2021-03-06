package com.bs.tphoto.dao;

import com.bs.tphoto.PageBean;
import com.bs.tphoto.entity.YAlbum;
import com.bs.tphoto.entity.YPhoto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @Author:zhuwj
 * @Description: 相册
 * @Date:Created in 10:22 2018/3/21
 */

@Mapper
public interface YAlbumMapper {

    /**
     * 根据喜欢数查询所有(由高到低)
     * @param pageBean
     * @return
     */
    @Select("select album.a_id,album.a_name,album.a_cover,album.a_describe," +
            "(select count(1) from y_album_like album_like where album_like.a_id = album.a_id) as likecount " +
            "from y_album album where album.a_state = 0 and album.a_privacy = 0 " +
            "order by likecount desc limit #{offset},#{rows}")
    List<YAlbum> selectAllByLikeCountDesc(PageBean pageBean);

    /**
     * 根据相册编号查询相片
     * @param aId
     * @return
     */
    @Select("select p_id,p_big,p_small,p_down,p_createDate from y_photo where a_id = #{aId} and p_state = 0 order by p_createDate limit #{offset},#{rows}")
    List<YPhoto> selectPhotosByAId(@Param("aId") String aId,@Param("offset")int offset ,@Param("rows") int rows);

}
