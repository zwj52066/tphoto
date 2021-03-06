package com.bs.tphoto.service;

import com.bs.tphoto.entity.YAlbum;
import com.bs.tphoto.entity.YPhoto;

import java.util.List;

/**
 * 相册
 */
public interface YAlbumService {

    /**
     * 根据喜欢数查询所有(由高到低)
     * @param page
     * @return
     */
     List<YAlbum> queryAllByLikeCountDesc(int page);


    /**
     * 根据相册编号查询相片
     * @param aId
     * @return
     */
     List<YPhoto> queryPhotosByAId(String aId,int page);

}
