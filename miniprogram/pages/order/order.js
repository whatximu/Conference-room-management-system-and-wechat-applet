
const app = getApp();


Page({
  data: {
    startTime: '09:00',
    endTime: '18:00',
    inputTime: '0.5',
    unit: 30,        // 展示时间单位（默认30分钟）
    reserveUnit: 30,  // 预约时间单位（默认60分钟）
    activedConst: 101, // 已经选中的常量标示
    disabledConst: 102, // 不可选的常量标示
    unreserveTime: [],// 三楼已被预定列表
    newunreserveTime: [], //七楼已被预订列表
    themeColor: '#fff',  // 插件的主题颜色
    orderInfo: [],
    picker: [],
    start_time:'xx:xx',
    end_time:'xx:xx',
    start_day:'xxxx-x-xx',
    datalength:0,
    datalength2:0,
    show_time:0,
    isShow: false,          // 默认不显示插件
    beginTime: '8:00',
    endTime: '22:00',
    timeGap: 30,
    themeColor: '#ffd00a',
    showOverdue: false,      // 默认显示过期时刻，false则隐藏已过期时刻
    calendarType: 'yytimes',
    days: 0,    //默认展示某天。正整数，0为当天    2.2.1
    time: '09:00',    //默认选中某天的某时刻,过期无效    2.2.1
    timeSlotList:[{timeStamp:'1618705800000',statue:0},{timeStamp:'1618705800000',statue:0}],
    timeSlotList2:[],
    timeSlotList3:[],
    room: '0'
  },

  showtime:function(e){
var that =this
var start_timea=that.data.start_time
var a=start_timea.substring(0, 2)
var aa=start_timea.substring(3, )
var end_timea=that.data.end_time
var b=end_timea.substring(0,2)
var bb=end_timea.substring(3,)
var ciso = Number(b)-Number(a)+(Number(bb)-Number(aa))/60

that.setData({
 show_time:ciso
})

  },
  submit_order:function(e) {
      
    var thisa=this
    var people=e.detail.value.people
    var content=e.detail.value.content
    var str = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
    var res = "";
    for(var i = 0; i < 20 ; i ++) {
     var id = Math.ceil(Math.random()*35);
     res += str[id];
   }



wx.request({
     
       url: 'http://localhost:8080/xxx/submit_application',
        method: 'POST',
        data: {
          apply_id: res,
          emp_id:app.globalData.empId,
          room_name:thisa.data.picker[thisa.data.room],
          content:content,
          people:people,
          apply_date:thisa.data.start_day,
          start_time:thisa.data.start_time,
          end_time:thisa.data.end_time

         
        },
        header: {

           "content-type":"application/json"
        },
        success(res) {
          console.log("123",res.data)

        

            wx.switchTab({
              url: '../ordernew/ordernew',
            })
          

        }
      })


    },

   // 点击显示插件
   btnClick2: function () {
    this.setData({
      isShow: true,
    })
  },

  _yybindchange: function (e) {
    var data = e.detail
    var that =this
    console.log(data)
    that.setData({
      start_day: data.year+'-'+data.month+'-'+data.day,
      start_time:data.times[0].beginTime,
      end_time:data.times[data.times.length-1].endTime
    })
    that.showtime(e)
  },

  _yybindhide: function () {
    console.log('隐藏')
  },

  //会议室选择器
  pickerChange(e) {
    var that = this
   
    that.setData({
      room: e.detail.value
    })
    that.getRoom_solt_time_List()
   
    wx.showLoading({
      title: '加载中',
    })
    if( e.detail.value == 0){
      that.onLoad()
    } else {
      that.SevenFloor()
    }
    wx.hideLoading();
  },
  //双向绑定输入预定时间单位
  changeLimit: function (e){
    let _this = this;
    let dataset = e.currentTarget.dataset;
    let value = e.detail.value
    let changeData = dataset.input;
    _this.data[changeData] = value
    _this.setData({
      reserveUnit: _this.data[changeData]*60
    });
  },
  //确定预约
  btnClick: function () {
    if (app.globalData.startTimeText == ''){
      wx.showToast({
        title: '请选择好预定的时间再点预定！',
        icon: 'none',
        duration: 2000
      })
      setTimeout(() => {
        wx.hideToast();
      }, 2000)
    } else {
      var that = this
      wx.showLoading({
        title: '预约中',
        mask: true,
      })
      
     
      
     
    }
  },
  btnDelete: function() {
    var that = this
    wx.showModal({
      title: '确认取消',
      content: '将取消您的最近预定，一但提交无法更改！',
      success: res => {
        if(res.confirm) {
          db.collection('order').where({
            username: app.globalData.username
          }).orderBy('startTime', 'desc').get({
            success: res => {
              db.collection('order').doc(res.data[0]._id).remove({
                success: res => {
                  wx.showToast({
                    title: '取消成功',
                    duration: 1500
                  })
                  setTimeout(function () {
                    wx.navigateBack()
                  }, 1500)
                },
                fail: err => {
                  wx.showToast({
                    icon: 'none',
                    title: '取消失败',
                  })
                }
              })
            }
          })
        }
      }
    })
  },


  detailInfo: function() {
    this.setData({
      isBackTo : false
    })
    if(this.data.room && this.data.room == 0){
      let orderInfo = JSON.stringify(this.data.orderInfo)
      wx.navigateTo({
        url: "../detail/detail?room=test1&orderInfo=" + orderInfo
      })
    }else{
      let orderInfo = JSON.stringify(this.data.orderInfo)
      wx.navigateTo({
        url: "../detail/detail?room=test2&orderInfo=" + orderInfo
      })
    }
  },

  onLoad: function(options) {
    var that = this;
    that.getRoomList()
    that.getRoom_solt_time_List()
  
    
   
    wx.request({
           
      url: 'http://localhost:8080/xxx/wxgetRoom_time',
      method:"GET",
    
      header: {
        "content-type":"application/json"
      },
  
      success:function(res){
                let temp = []
        let temp2 = []
        for(let i=0;i<res.data.data.length;i++){
          temp.push({
            startTime : res.data.data[i].start_time,
            endTime : res.data.data[i].end_time,
            // status : res.data.data[i].status
            status : 102
          })

        }

        that.setData({
          unreserveTime: temp,

        })
      }
    })
   
    
      
  
   
  },
  getRoomList:function(){
    var self =this 
    wx.request({
           
      url: 'http://localhost:8080/xxx/wxgetAllRoom2',
      method:"GET",
    
      header: {
        "content-type":"application/json"
      },
  
      success:function(res){
        
        console.log(res.data.asd)
        self.setData({
        //   hasOrder:true,
          // price:Allprice,
          picker:res.data.data
        })
      }

    })
  },

  getRoom_solt_time_List(){
    var that =this 
   
    console.log(that.data.picker)
    
    wx.request({
           
      url: 'http://localhost:8080/xxx/getRoom_solt_State',
      method:"POST",
    
         data:{
           room_name:that.data.picker[that.data.room]
          },
      header: {
        "content-type":"application/json"

      },
  
      success:function(res){
        
        console.log(res.data)
        that.setData({

          timeSlotList2:res.data.ax,
          datalength:res.data.ax.length
        })
  
        
      }
    })
    
    that.getRoom_solt_time_list2()
    wx.request({
           
      url: 'http://localhost:8080/xxx/getRoom_solt_State2',
      method:"POST",
    
         data:{
           room_name:that.data.picker[that.data.room]
          },
      header: {
        "content-type":"application/json"

      },
  
      success:function(res){
        
        console.log(res.data)
        that.setData({

          timeSlotList3:res.data.ax,
          datalength2:res.data.ax.length
        })
        that.wxlist(that.data.datalength)
        
      }
    })
    
    

      that.wxlist(that.data.datalength)
  },

  getRoom_solt_time_list2(){
      var that=this
    wx.request({
           
      url: 'http://localhost:8080/xxx/getRoom_solt_State2',
      method:"POST",
    
         data:{
           room_name:that.data.picker[that.data.room]
          },
      header: {
        "content-type":"application/json"
      },
  
      success:function(res){
        

        that.setData({

          timeSlotList3:res.data.ax,
          datalength2:res.data.ax.length
        })
        that.wxlist(that.data.datalength)
        
      }
      
    })
    
    

  },
 
  wxlist:function(datalength,datalength2){
    var that =this

    console.log('ndzwsmbhwxx',datalength,datalength2);
    var newarray = []
    for (let i = 0; i <datalength; ++i){
      console.log(that.data.timeSlotList2[i])
      console.log('aaa')
      var a=that.data.timeSlotList2[i].substring(0, 13)
      var b=that.data.timeSlotList3[i].substring(0, 13)
      newarray.push({timeStamp:a, statue: 0 })
      var cc=Number(a)
      var ca=Number(b)

     
      newarray.push({timeStamp:b, statue: 0 })


      
    }
    console.log(newarray)
    that.setData({
     
        timeSlotList:newarray
       
      })
    

 
  },
  SevenFloor: function(){
    var that = this;

  },


  onSelectTime(e) {
    const { startTimeText, endTimeText } = e.detail;
    app.globalData.startTimeText = startTimeText
    app.globalData.endTimeText = endTimeText
  }

})