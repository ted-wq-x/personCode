package wangqiang.website.behavioralType.chain;

/**
 * 项目名称：  latke<br>
 * 类名称：  HelloHandler<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/24 0024 16:13
 */
public class HelloHandler implements Handler {
    @Override
    public void handler(String name, CoreController controller) {
        System.out.println(name+":调用HelloHandler，我曹！");
        //执行调用
        controller.nextHandler();
    }
}
