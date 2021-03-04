# SpringBootPermission
SpringBoot通过注解实现权限校验

参考https://blog.csdn.net/Zllvincent/article/details/104883410/



测试：

1、访问 `http://localhost:8080/login`    -- 不需要权限能直接访问到

2、访问 `http://localhost:8080/test-read`  -- 有权限访问

3、访问 `http://localhost:8080/hello`  -- 没有权限，抛出错误

