var seg = 0;
var mnt = 0;
var hrs = 0;
var ml = 0;
var actual;
//comienzo.onclick(running);

function inicio(){
  var btn = document.getElementById("Start").value;
  if(btn === "Comenzar"){
    document.getElementById("Start").value = "Pausar";
    control = setInterval(timer,100);
  }else if(btn === "Pausar"){
    document.getElementById("Start").value = "Continuar";
    clearInterval(control);
  }else{
    document.getElementById("Start").value = "Pausar";
    control = setInterval(timer,100);
  }
}

function parar(){
  clearInterval(control);
  tiempo.innerHTML = "00:00:00:00";
  document.getElementById("Start").value = "Comenzar"
  seg = 0;
  mnt = 0;
  hrs = 0;
  ml = 0;
}

function timer(){
    actual = "";
    ml++;
    if(ml === 10){
      seg ++;
      ml = 0;
    }
    actual = ":0" + ml;
    if(seg === 60){
      mnt++;
      seg = 0;
    }
    if (seg < 10){
      actual = ":0" + seg + actual;
    }else{
      actual = ":" + seg +actual;
    }
    if(mnt === 60){
      hrs ++;
      mnt = 0;
    }
    if (mnt < 10){
      actual = ":0" + mnt + actual;
    }else{
      actual = ":" + mnt + actual;
    }
    if(hrs < 9){
      actual = "0" + hrs + actual;
    }else{
      actual = hrs + actual;
    }
    tiempo.innerHTML = actual;
  }