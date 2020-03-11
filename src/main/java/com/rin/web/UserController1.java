package com.rin.web;

import com.rin.entity.User;
import com.rin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Api(tags = "用户管理（数据库）")
@AllArgsConstructor
@RestController
@RequestMapping(value = "/user-sql", produces = "application/json; charset=utf-8")
public class UserController1 {

    private UserService userService;
    private static String success = "{\n" +
            "  \"resultCode\": \"0\",\n" +
            "  \"errorMsg\": \"success\"\n" +
            "}";

    //处理Get请求，查询所有user列表
    @GetMapping("/")
    @ApiOperation("获取用户列表")
    public List<User> getUserList() {
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<User> u = userService.getList();
        return u;
    }

    //处理POST请求，新增user
    @PostMapping("/")
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    public String postUser(@Valid @RequestBody User user) {
        // @RequestBody注解用来绑定通过http请求中application/json类型上传的数据
        userService.createUser(user);
        return success;
    }

    //处理"/userSql/{id}"的GET请求，用来获取url中name值的User信息
    @GetMapping("/{id}")
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    public List<User> getUser(@PathVariable int id) {
        // url中的id可通过@PathVariable绑定到函数的参数中
        return userService.getUser(id);
    }

    //处理PUT请求，更新url中id的user数据
    @PutMapping("/{id}")
    @ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "用户编号", required = true, example = "1")
    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    public String putUser(@Valid @RequestBody User user, @PathVariable Long id) {
        userService.updateUser(id.intValue(), user);
        return success;
    }

    //处理DELETE请求，删除url中指定的id的user
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id.intValue());
        return success;
    }

}
