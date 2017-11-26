package wangqiang.website.behavioralType.chain;

import java.util.Iterator;
import java.util.List;

/**
 * 项目名称：  latke<br>
 * 类名称：  CoreController<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/24 0024 16:08
 */
public class CoreController {
    private Iterator<Handler> iterator;
    private String name;

    public CoreController(List<Handler> handlers,String name) {
         this.iterator = handlers.iterator();
         this.name = name;
    }

    public void nextHandler() {
        if (iterator.hasNext()) {
            iterator.next().handler(name,this);
        } else {
            System.out.println(name+":调用结束!");
        }
    }
}
