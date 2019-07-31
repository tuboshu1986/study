/**
 * 
 */
var data = [{
	title: '一级1',
	id: 1,
	checked: true,
	spread: true,
	children: [{
		title: '二级1-1可允许跳转',
		id: 3,
		href: 'https: //www.layui.com/',
		children: [{
			title: '三级1-1-3',
			id: 23,
			children: [{
				title: '四级1-1-3-1',
				id: 24,
				children: [{
					title: '五级1-1-3-1-1',
					id: 30
				},
				{
					title: '五级1-1-3-1-2',
					id: 31
				}]
			}]
		},
		{
			title: '三级1-1-1',
			id: 7,
			children: [{
				title: '四级1-1-1-1可允许跳转',
				id: 15,
				href: 'https: //www.layui.com/doc/'
			}]
		},
		{
			title: '三级1-1-2',
			id: 8,
			children: [{
				title: '四级1-1-2-1',
				id: 32
			}]
		}]
	},
	{
		title: '二级1-2',
		id: 4,
		spread: true,
		children: [{
			title: '三级1-2-1',
			id: 9,
			disabled: true
		},
		{
			title: '三级1-2-2',
			id: 10
		}]
	},
	{
		title: '二级1-3',
		id: 20,
		children: [{
			title: '三级1-3-1',
			id: 21
		},
		{
			title: '三级1-3-2',
			id: 22
		}]
	}]
},
{
	title: '一级2',
	id: 2,
	spread: true,
	children: [{
		title: '二级2-1',
		id: 5,
		spread: true,
		children: [{
			title: '三级2-1-1',
			id: 11
		},
		{
			title: '三级2-1-2',
			id: 12
		}]
	},
	{
		title: '二级2-2',
		id: 6,
		children: [{
			title: '三级2-2-1',
			id: 13
		},
		{
			title: '三级2-2-2',
			id: 14,
			disabled: true
		}]
	}]
},
{
	title: '一级3',
	id: 16,
	children: [{
		title: '二级3-1',
		id: 17,
		fixed: true,
		children: [{
			title: '三级3-1-1',
			id: 18
		},
		{
			title: '三级3-1-2',
			id: 19
		}]
	},
	{
		title: '二级3-2',
		id: 27,
		children: [{
			title: '三级3-2-1',
			id: 28
		},
		{
			title: '三级3-2-2',
			id: 29
		}]
	}]
}];



var data1 = [{
	title: '江西',
	id: 1,
	children: [{
		title: '南昌',
		id: 1000,
		children: [{
			title: '青山湖区',
			id: 10001
		},
		{
			title: '高新区',
			id: 10002
		}]
	},
	{
		title: '九江',
		id: 1001
	},
	{
		title: '赣州',
		id: 1002
	}]
},
{
	title: '广西',
	id: 2,
	children: [{
		title: '南宁',
		id: 2000
	},
	{
		title: '桂林',
		id: 2001
	}]
},
{
	title: '陕西',
	id: 3,
	children: [{
		title: '西安',
		id: 3000
	},
	{
		title: '延安',
		id: 3001
	}]
}];

var data2 = [{
	title: '早餐',
	id: 1,
	children: [{
		title: '油条',
		id: 5
	},
	{
		title: '包子',
		id: 6
	},
	{
		title: '豆浆',
		id: 7
	}]
},
{
	title: '午餐',
	id: 2,
	checked: true,
	children: [{
		title: '藜蒿炒腊肉',
		id: 8
	},
	{
		title: '西湖醋鱼',
		id: 9
	},
	{
		title: '小白菜',
		id: 10
	},
	{
		title: '海带排骨汤',
		id: 11
	}]
},
{
	title: '晚餐',
	id: 3,
	children: [{
		title: '红烧肉',
		id: 12,
		fixed: true
	},
	{
		title: '番茄炒蛋',
		id: 13
	}]
},
{
	title: '夜宵',
	id: 4,
	children: [{
		title: '小龙虾',
		id: 14,
		checked: true
	},
	{
		title: '香辣蟹',
		id: 15,
		disabled: true
	},
	{
		title: '烤鱿鱼',
		id: 16
	}]
}];