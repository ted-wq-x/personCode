package wangqiang.website.behavioralType.chain;

import java.util.ArrayList;

/**
 * 项目名称：  latke<br>
 * 类名称：  Main<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/24 0024 16:14
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Handler> handlers = new ArrayList<>();
        handlers.add(new HelloHandler());
        handlers.add(new AdviceHandler());
        CoreController coreController = new CoreController(handlers, "wq");
        coreController.nextHandler();
    }
}
