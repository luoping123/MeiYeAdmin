package com.sct.meiye.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sct.meiye.mapper.NoticeMapper;
import com.sct.meiye.domain.Notice;
import com.sct.meiye.service.INoticeService;

/**
 * 滚动通知Service业务层处理
 * 
 * @author sct
 * @date 2022-05-17
 */
@Service
public class NoticeServiceImpl implements INoticeService 
{
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 查询滚动通知
     * 
     * @param id 滚动通知主键
     * @return 滚动通知
     */
    @Override
    public Notice selectNoticeById(Long id)
    {
        return noticeMapper.selectNoticeById(id);
    }

    /**
     * 查询滚动通知列表
     * 
     * @param notice 滚动通知
     * @return 滚动通知
     */
    @Override
    public List<Notice> selectNoticeList(Notice notice)
    {
        return noticeMapper.selectNoticeList(notice);
    }

    /**
     * 新增滚动通知
     * 
     * @param notice 滚动通知
     * @return 结果
     */
    @Override
    public int insertNotice(Notice notice)
    {
        return noticeMapper.insertNotice(notice);
    }

    /**
     * 修改滚动通知
     * 
     * @param notice 滚动通知
     * @return 结果
     */
    @Override
    public int updateNotice(Notice notice)
    {
        return noticeMapper.updateNotice(notice);
    }

    /**
     * 批量删除滚动通知
     * 
     * @param ids 需要删除的滚动通知主键
     * @return 结果
     */
    @Override
    public int deleteNoticeByIds(Long[] ids)
    {
        return noticeMapper.deleteNoticeByIds(ids);
    }

    /**
     * 删除滚动通知信息
     * 
     * @param id 滚动通知主键
     * @return 结果
     */
    @Override
    public int deleteNoticeById(Long id)
    {
        return noticeMapper.deleteNoticeById(id);
    }
}
