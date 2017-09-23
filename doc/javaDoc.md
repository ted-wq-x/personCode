# java doc中的标签

|标签	|描述	|示例|
|---|---|----|
|@author	|标识一个类的作者|	@author description|
|@deprecated|	指名一个过期的类或成员	|@deprecated description|
|@exception	|标志一个类抛出的异常	|@exception exception-name explanation|
|@param	|说明一个方法的参数	|@param parameter-name explanation|
|@return|	说明返回值类型	|@return explanation|
|@see	|指定一个到另一个主题的链接	|@see anchor|
|@serial|	说明一个序列化属性	|@serial description|
|@serialData	|说明通过writeObject( ) 和 writeExternal( )方法写的数据|	@serialData description|
|@serialField	|说明一个ObjectStreamField组件|	@serialField name type description|
|@since	|标记当引入一个特定的变化时	|@since release|
|@throws	|和 @exception标签一样.	|The @throws tag has the same meaning as the |@exception tag.|
|@version	|指定类的版本	 |@version info|
|{@value}	|显示常量的值，该常量必须是static属性。	|Displays the value of a constant, which must be a static field.|
|{@linkplain}|	插入一个到另一个主题的链接，但是该链接显示纯文本字体	|Inserts an in-line link to another topic.|
|{@docRoot}	|指明当前文档根目录的路径	|Directory Path|
|{@inheritDoc}|	从直接父类继承的注释	|Inherits a comment from the immediate surperclass.|
|{@link}	|插入一个到另一个主题的链接	|{@link name text}|

下面的几个带`{}`的是写在注释里面的。