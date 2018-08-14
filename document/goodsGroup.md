1.测试环境域名:

2.生产环境域名:

1.添加商品组
------------------------------------
URL:/goodsGroup/saveGoodsGroup

RequestMethod:POST

请求参数说明:

|参数|参数类型|说明|
|---|---------|----|
|goodsGroupName|String|商品组名称(必传)|
|goodsGroupDescribe|String|商品组描述(可选)|

返回示例:
```
{
    "code": 200,
    "message": "操作成功",
    "result": null
}
```

2.删除商品组
------------------------------------
URL:/goodsGroup/deleteGoodsGroup

RequestMethod:GET

请求参数说明:

|参数|参数类型|说明|
|---|---------|----|
|goodsGroupIds|String[]|商品组id (必传)|

返回示例:
```
{
    "code": 200,
    "message": "操作成功",
    "result": null
}
```

3.修改商品组
------------------------------------
URL:/goodsGroup/updateGoodsGroup

RequestMethod:POST

请求参数说明:

|参数|参数类型|说明|
|---|---------|----|
|id|String|商品组id(必传)|
|GoodsGroupName|String|商品组名称(可选)|
|goodsGroupDescribe|String|商品组描述(可选)|

返回示例:
```
{
    "code": 200,
    "message": "操作成功",
    "result": null
}
```

4.查询商品组
------------------------------------
URL:/goodsGroup/queryGoodsGroupByPage

RequestMethod:GET

请求参数说明:

|参数|参数类型|说明|
|---|---------|----|
|page|Integer|当前页数 分页查询必传，下拉菜单查询page = 0|
|rows|Integer|每页行数 分页查询必传，下拉菜单查询rows = 0|
|goodsGroupName|String|商品组名称(可选)|

返回示例:
```
{
    "code": 200,
    "message": "操作成功",
    "result": [
        {
            "id": "22332045538d4041806f15f28ee7b290",   //主键id
            "goodsGroupName": "容器4",    //组名称
            "goodsGroupDescribe": "容器4",    //描述
            "createTime": "2018-08-03 17:50:34", //创建时间
            "updateTime": "2018-08-03 17:53:23" //修改时间
        },
        {
            "id": "95ddec2d5f2e48639aa720da4dfc8ae0",
            "goodsGroupName": "云服务",
            "goodsGroupDescribe": "yunfuwu",
            "createTime": "2018-08-03 17:49:59",
            "updateTime": null
        }
    ]
}
```

5.根据id查询商品组
------------------------------------
URL:/goodsGroup/queryGoodsGroupById

RequestMethod:GET

请求参数说明:

|参数|参数类型|说明|
|---|---------|----|
|id|String|产品组id (必传)|

返回示例:
```
{
    "code": 200,
    "message": "操作成功",
    "result": {
        "id": "95ddec2d5f2e48639aa720da4dfc8ae0",   //主键id
        "goodsGroupName": "云服务",    //组名称
        "goodsGroupDescribe": "yunfuwu",    //描述
        "createTime": "2018-08-03 17:49:59",
        "updateTime": null
    }
}