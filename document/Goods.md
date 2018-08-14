1.测试环境域名:

2.生产环境域名:

1.添加商品
------------------------------------
URL:/goods/saveGoods

RequestMethod:POST

请求参数说明:

|参数|参数类型|说明|
|---|---------|----|
|goodsGroupId|String|商品组id|
|goodsGroupName|String|商品组名称|
|GoodsName|String|商品名称|
|billingPattern|String|计费模式 0:按需;1:包年包月;2:按需和包年包月|
|regionId|String|区域id|
|regionName|String|区域名称|
|priceType|String|商品的计价方式 0:单价;1:固定价格|
|goodsProperty|String[]|商品的属性|
|goodsType|String[]|商品的类型|

请求示例:
```
{
	"goodsGroupId":"16a6928ec2094b7f853168b84b230e3d",
	"goodsGroupName":"云服务",
	"goodsName":"云主机",
	"billingPattern":"2",
	"regionId":"cf7e2976765b44c6a543f049e96c926c",
	"regionName":"北京三区",
	"goodsProperty":"cpu,ram",
	"priceType":"1",
	"goodsType":"标准型,高性能性"
}
```

返回示例:
```
{
    "code": 200,
    "message": "操作成功",
    "result": null
}
```

2.根据商品id查询商品类型,商品的属性,商品的计费模式和计价方式
------------------------------------
URL:/goods/queryGoodsInformation

RequestMethod:GET

请求参数说明:

|参数|参数类型|说明|
|---|---------|----|
|goodsId|String|商品id (必传)|

返回示例:
```
{
    "code": 200,
    "message": "操作成功",
    "result": {
        "goodsTypeList": [  //商品类型集合
            {
                "id": "4fc50d49385b4db298bdf9d7fdbe2c18",   //商品类型id
                "goodsId": "009482b97d4541aabaa14cf1f15b5250",  //商品id
                "goodsType": "标准型", //商品类型名称
                "createTime": "2018-08-10 11:32:37"
            },
            {
                "id": "b71c7eded2444821932cb7ae44b4ca1a",
                "goodsId": "009482b97d4541aabaa14cf1f15b5250",
                "goodsType": "高性能性",
                "createTime": "2018-08-10 11:32:37"
            }
        ],
        "goodsPropertyList": [  //商品属性名称
            "cpu",
            "ram"
        ],
        "billingPattern": "1",  //计费模式 0:按需;1:包年包月;2:按需和包年包月
        "priceType": "0"    //商品的计价方式 0:单价;1:固定价格
    }
}
```

3.创建商品价格/修改商品价格(修改时传值与创建相同,全部数据)
------------------------------------
URL:/goods/saveGoodsPrice

RequestMethod:POST

请求参数说明:

|参数|参数类型|说明|
|---|---------|----|
|goodsId|String|商品id (必传)|

请求示例:
```

	[
		{
			"propertyPrice":"{\"cpu\":"1\",\"ram\":\"1\"}", //商品的属性和对应的值的json
			"priceNeed":"500",  //商品的按需单价
			"priceMonth":"7000",    //商品的按月单价
			"goodsId":"009482b97d4541aabaa14cf1f15b5250",   //商品的id
			"goodsTypeId":"4fc50d49385b4db298bdf9d7fdbe2c18",   //商品类型id
			"goodsTypeName":"标准型"   //商品类型名称
		},
		{
			"propertyPrice":"{\"cpu\":\"1\",\"ram\":\"2\"}",
			"priceNeed":"0.06",
			"priceMonth":"0.6",
			"goodsId":"009482b97d4541aabaa14cf1f15b5250",
			"goodsTypeId":"4fc50d49385b4db298bdf9d7fdbe2c18",
			"goodsTypeName":"标准型"
		},
		{
			"propertyPrice":"{\"cpu\":\"2\",\"ram\":\"2\"}",
			"priceNeed":"0.07",
			"priceMonth":"0.7",
			"goodsId":"009482b97d4541aabaa14cf1f15b5250",
			"goodsTypeId":"4fc50d49385b4db298bdf9d7fdbe2c18",
			"goodsTypeName":"标准型"
		},
		{
			"propertyPrice":"{\"cpu\":\"1\",\"ram\":\"1\"}",
			"priceNeed":"0.1",
			"priceMonth":"10",
			"goodsId":"009482b97d4541aabaa14cf1f15b5250",
			"goodsTypeId":"b71c7eded2444821932cb7ae44b4ca1a",
			"goodsTypeName":"高性能性"
		}
		]

```

返回示例:
```
{
    "code": 200,
    "message": "操作成功",
    "result": null
}
```

4.删除商品
------------------------------------
URL:/goods/deleteGoods

RequestMethod:GET

请求参数说明:

|参数|参数类型|说明|
|---|---------|----|
|ids|String[]|商品id (必传)|

返回示例:
```
{
    "code": 200,
    "message": "操作成功",
    "result": null
}
```

5.修改商品信息,商品价格除外(修改内容包括发布,下架,商品名称,计费模式，区域)
------------------------------------
URL:/goods/updateGoodsProperty

RequestMethod:POST

请求参数说明:

|参数|参数类型|说明|
|---|---------|----|
|id|String|商品id (必传)|
|goodsName|String|商品名称 (可选)|
|billingPattern|String|计费模式 0:按需;1:包年包月;2:按需和包年包月(可选)|
|regionId|String|区域id (可选)|
|regionName|String|区域名称(可选)|
|status|String|商品的状态 0:未发布;1:上架;2:下架;(可选)|

返回示例:
```
{
    "code": 200,
    "message": "操作成功",
    "result": null
}
```

6.根据条件分页查询商品列表
------------------------------------
URL:/goods/queryGoodsByPage

RequestMethod:GET

请求参数说明:

|参数|参数类型|说明|
|---|---------|----|
|page|Integer|页码(必传)|
|rows|Integer|行数(必传)|
|goodsName|String|商品名称(可选)|
|regionId|String|区域id (可选)|
|regionName|String|区域名称(可选)|
|status|String|商品的状态 0:未发布;1:上架;2:下架;(可选)|

返回示例:
```
{
    "code": 200,
    "message": "操作成功",
    "result": {
        "pageNum": 1,
        "pageSize": 10,
        "size": 1,
        "startRow": 1,
        "endRow": 1,
        "total": 1,
        "pages": 1,
        "list": [
            {
                "id": "009482b97d4541aabaa14cf1f15b5250",   //商品主键id
                "goodsGroupId": "16a6928ec2094b7f853168b84b230e3d", //商品组id
                "goodsGroupName": "云服务",    //商品组名称
                "goodsName": "云主机产品",   //商品名称
                "billingPattern": "1",  //计费模式 0:按需;1:包年包月;2:按需和包年包月
                "regionId": "c0f60fce45df4eada4cc8e2bf4b2ea6d", //区域id
                "regionName": "北京二区",   //区域名称
                "goodsProperty": "cpu,ram", //商品属性
                "priceType": "0",   //商品的计价方式 0:单价;1:固定价格
                "status": "0",  //商品的状态 0:未发布;1:上架;2:下架;
                "createTime": "2018-08-10 11:32:37",    //商品的创建时间
                "updateTime": "2018-08-10 14:09:42",    //商品的修改时间
                "upTime": null, //商品的发布(上架)时间
                "downTime": null,   //商品的下架时间
                "goodsType": null   //
            }
        ],
        "prePage": 0,
        "nextPage": 0,
        "isFirstPage": true,
        "isLastPage": true,
        "hasPreviousPage": false,
        "hasNextPage": false,
        "navigatePages": 8,
        "navigatepageNums": [
            1
        ],
        "navigateFirstPage": 1,
        "navigateLastPage": 1,
        "lastPage": 1,
        "firstPage": 1
    }
}
```

7.查看，查看某个商品的详情
------------------------------------
URL:/goods/queryGoodsPropertyById

RequestMethod:GET

请求参数说明:

|参数|参数类型|说明|
|---|---------|----|
|id|String|商品主键id(必传)|

返回示例:
```
{
    "code": 200,
    "message": "操作成功",
    "result": {
        "id": "009482b97d4541aabaa14cf1f15b5250",   //商品主键id
        "goodsGroupId": "16a6928ec2094b7f853168b84b230e3d", //商品组id
        "goodsGroupName": "云服务",    //商品组名称
        "goodsName": "云主机产品",   //商品名称
        "billingPattern": "1",  //计费模式 0:按需;1:包年包月;2:按需和包年包月
        "regionId": "c0f60fce45df4eada4cc8e2bf4b2ea6d", //区域id
        "regionName": "北京二区",   //区域名称
        "priceType": "0",   //商品的计价方式 0:单价;1:固定价格
        "status": "0",  //商品的状态 0:未发布;1:上架;2:下架;
        "createTime": "2018-08-10 11:32:37",    //创建时间
        "updateTime": "2018-08-10 14:09:42",    //修改时间
        "upTime": null, //发布时间
        "downTime": null,   //下架时间
        "goodsTypePriceVoList": [
            {
                "goodsTypeId": "4fc50d49385b4db298bdf9d7fdbe2c18",  //商品类型id
                "goodsTypeName": "标准型", //商品类型名称
                "propertyPriceVoList": [
                    {
                        "propertyPrice": "{"cpu":"1","ram":"2"}",   //商品配置以及配置值
                        "priceNeed": "0.06",    //对应的按需价格
                        "priceMonth": "0.6" //对应的按月价格
                    },
                    {
                        "propertyPrice": "{"cpu":"1","ram":"1"}",
                        "priceNeed": "0.05",
                        "priceMonth": "0.5"
                    }
                ]
            },
            {
                "goodsTypeId": "b71c7eded2444821932cb7ae44b4ca1a",
                "goodsTypeName": "高性能性",
                "propertyPriceVoList": [
                    {
                        "propertyPrice": "{"cpu":"1","ram":"1"}",
                        "priceNeed": "0.1",
                        "priceMonth": "10"
                    }
                ]
            }
        ]
    }
}
```

8.导出商品价格
------------------------------------
URL:/goods/exportGoodsPrice

RequestMethod:POST

请求参数说明:

|参数|参数类型|说明|
|---|---------|----|
|rows|String|列的属性名(必传)|
|stringList|List<String>|价格信息(必传)|

返回示例:
```
[
    {
        "propertyPrice": "[{cpu:1,ram:1,按需:0.1,包年包月:1},{cpu:1,ram:2,按需:0.2,包年包月:2},{cpu:2,ram:2,按需:0.3,包年包月:3}]",
        "goodsType": "标准型",
        "property": "cpu,ram,按需,包年包月"
    },
    {
        "propertyPrice": "[{cpu:1,ram:1,按需:1,包年包月:10}]",
        "goodsType": "高性能型",
        "property": "cpu,ram,按需,包年包月"
    }
]
```
