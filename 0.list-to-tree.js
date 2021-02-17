userList = [
    {name: 'user1', age: 18, province: '四川', city: '成都', district: '高新区'},
    {name: 'user2', age: 19, province: '四川', city: '成都', district: '天府新区'},
    {name: 'user3', age: 20, province: '四川', city: '南充', district: '顺庆区'},
    {name: 'user4', age: 21, province: '江苏', city: '南京', district: '鼓楼区'},
    {name: 'user5', age: 22, province: '江苏', city: '南京', district: '玄武区'},
    {name: 'user6', age: 23, province: '江苏', city: '镇江', district: '京口区'},
]

data = [
    {name: 'name1', a: 'a1', b: 'b1', c: 'c1', d: 'd1', e: 'e1', f: 'f1'},
    {name: 'name2', a: 'a2', b: 'b2', c: 'c2', d: 'd2', e: 'e2', f: 'f2'},
    {name: 'name3', a: 'a3', b: 'b3', c: 'c3', d: 'd3', e: 'e3', f: 'f3'},
]

function list2tree(list, path) {
    let levels = path.split('/')
    let res = {
        id: 'root',
        name: 'root',
        children: [],
    }

    let cur
    let map = new Map()    // k: name, v: node
    list.forEach(item => {
        cur = res
        for (let level of levels) {
            let pre = cur
            let name = item[level]
            if (!map.has(name)) {
                let node = {
                    name: name,
                    level: level,
                    children: [],
                }
                pre.children.push(node)
                cur = node
                map.set(name, cur)
            } else {
                cur = map.get(name)
            }
        }

        // 用不在 {levels} 中的属性创建一个新对象，添加到 {cur.children} 中
        if (levels.length < Object.keys(item)) {
            let obj = {}
            for (let key in item) {
                if (!levels.includes(key)) {
                    obj[key] = item[key]
                }
            }
            cur.children.push(obj)
        }
    })

    return res
}

let userTree = list2tree(userList, 'province/city/district')
console.log(userTree)

let dataTree = list2tree(data, 'a/c');
console.log(dataTree)
