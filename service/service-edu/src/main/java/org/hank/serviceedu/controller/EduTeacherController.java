package org.hank.serviceedu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Delete;
import org.hank.commonutils.R;
import org.hank.serviceedu.entity.EduTeacher;
import org.hank.serviceedu.query.TeacherQuery;
import org.hank.serviceedu.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author hank
 * @since 2021-03-09
 */
@RestController
@RequestMapping("/serviceedu/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation("所有讲师列表")
    @GetMapping
    public R list() {
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("items", list);
    }

    @ApiOperation("根据ID删除讲师")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id) {
        boolean result = teacherService.removeById(id);
        if (result) {
            return R.ok();
        }
        return R.error().message("删除失败");
    }

    @ApiOperation("分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录条数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
                    TeacherQuery teacherQuery) {
        Page<EduTeacher> pageParam = new Page<>(page, limit);
        teacherService.pageQuery(pageParam, teacherQuery);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }

    /**
     * 新增
     *
     * @param teacher
     * @return
     */
    @ApiOperation("新增讲师")
    @PostMapping
    public R save(
            @ApiParam(name = "teacher",value = "讲师对象",required = true)
            @RequestBody EduTeacher teacher) {
        teacherService.save(teacher);
        return R.ok();

    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @ApiOperation("根据ID查询讲师")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id",value = "讲师ID",required = true)
            @PathVariable String id) {

        EduTeacher teacher = teacherService.getById(id);
        return R.ok().data("item", teacher);
    }

    /**
     * 根据ID修改
     *
     * @param id
     * @param teacher
     * @return
     */
    @ApiOperation("根据ID修改讲师")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id",value = "讲师ID",required = true)
            @PathVariable String id,
            @ApiParam(name = "teacher",value = "讲师对象",required = true)
            @RequestBody EduTeacher teacher) {
        teacher.setId(id);
        teacherService.updateById(teacher);
        return R.ok();
    }
}

