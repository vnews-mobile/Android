package com.mobile.vnews.module.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import com.mobile.vnews.module.bean.Word;
import com.mobile.vnews.module.bean.WordCollect;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.DELETE;

/**
 * Created by xuantang on 12/6/17.
 */

@Dao
public interface WordDao {

    @Query("SELECT words.ID as id, word, pos.name as pos, voice, means.means as means, " +
            "pos.means as posmeans, exchange " +
            "FROM words, pos, means " +
            "WHERE word = :word AND pos.ID = means.posID AND words.ID = means.wordID")
    List<Word> getWordsByName(String word);

    @Query("SELECT words.ID as id, word, pos.name as pos, voice, means.means as means, " +
            "pos.means as posmeans, exchange " +
            "FROM words, pos, means " +
            "WHERE word like :word AND pos.ID = means.posID AND words.ID = means.wordID " +
            "LIMIT :start, :count")
    List<Word> getWordsByLikeName(String word, int start, int count);

    @Query("SELECT word " +
            "FROM words " +
            "WHERE word like :word " +
            "LIMIT :start, :count")
    List<String> getSimpleWordsByLikeName(String word, int start, int count);

    @Query("SELECT words.ID as id, word, pos.name as pos, voice, means.means as means, " +
            "pos.means as posmeans , exchange " +
            "FROM words, pos, means " +
            "WHERE words.ID = :ID AND pos.ID = means.posID AND words.ID = means.wordID")
    List<Word> getWordsByID(int ID);

    @Query("SELECT * FROM word_collect WHERE tag = :tag")
    List<WordCollect> getWordCollectsByTag(String tag);

    @Query("SELECT * FROM word_collect")
    List<WordCollect> getWordCollects();

    @Query("SELECT distinct(tag) FROM word_collect")
    List<String> getWordCollectType();
    @Insert
    void addWordCollect(WordCollect wordCollect);

    @Delete
    void removeWordCollect(WordCollect wordCollect);

}