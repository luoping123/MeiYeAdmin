package com.sct.meiye.mapper;

import java.util.List;
import com.sct.meiye.domain.Notice;

/**
 * 滚动通知Mapper接口
 * 
 * @author sct
 * @date 2022-05-17
 */
public interface NoticeMapper 
{
    /**
     * 查询滚动通知
     * 
     * @param id 滚动通知主键
     * @return 滚动通知
     */
    public Notice selectNoticeById(Long id);

    /**
     * 查询滚动通知列表
     * 
     * @param notice 滚动通知
     * @return 滚动通知集合
     */
    public List<Notice> selectNoticeList(Notice notice);

    /**
     * 新增滚动通知
     * 
     * @param notice 滚动通知
     * @return 结果
     */
    public int insertNotice(Notice notice);

    /**
     * 修改滚动通知
     * 
     * @param notice 滚动通知
     * @return 结果
     */
    public int updateNotice(Notice notice);

    /**
     * 删除滚动通知
     * 
     * @param id 滚动通知主键
     * @return 结果
     */
    public int deleteNoticeById(Long id);

    /**
     * 批量删除滚动通知
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNoticeByIds(Long[] ids);
}
