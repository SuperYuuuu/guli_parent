package org.hank.serviceedu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.hank.serviceedu.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import org.hank.serviceedu.query.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author hank
 * @since 2021-03-09
 */
public interface EduTeacherService extends IService<EduTeacher> {
    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);
}
