# JWT-Demo

本项目是一个自己实现的 JWT Demo，虽然它只是一个小 Demo，但里面涉及到的内容还挺多～

总结一下这个 Demo 中包含的内容：

- 使用 JWT 进行认证和授权
- 使用`@ControllerAdvice`和`@ExceptionHandler`实现全局异常处理 (**详情可见 [统一异常处理](https://lfool.github.io/LFool-Notes/spring/Spring-MVC.html#统一异常处理)**)
- 使用 Spring MVC 拦截器，拦截 Controller 层方法，执行方法前统一进行访问权限控制 (**详情可见 [拦截器](https://lfool.github.io/LFool-Notes/spring/Spring-MVC.html#font-color1fa774拦截器font)**)
- 实现自定义注解，结合拦截器，在需要进行访问权限控制的方法上添加`@NeedToken`，在不需要进行访问权限控制的方法上添加`@PassToken`，这里使用了反射机制获取方法上的注解



另外，有一个篇关于 JWT 的总结性文章 👉 **[JWT](https://lfool.github.io/LFool-Notes/spring/JWT.html)**
