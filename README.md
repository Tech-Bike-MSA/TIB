# TIB
Tech Innovation Bike Rental System (Awesome Rental System)

## Event Storming Diagram
<img width="1159" alt="image" src="https://user-images.githubusercontent.com/108508730/215334901-29cc258a-54df-4ad0-aee3-3bf27ce5a28c.png">


## 자전거 반납 비동기 처리에 대한 부가 설명
* 반납 프로세스
  * 자전거가 반납됨과 동시에 결제 이벤트가 결제 모듈로 발행됨
* 사용자의 가용성 증가를 위한 비동기 처리
  * 결제 프로세스를 비동기적으로 처리함으로써 사용자는 반납과 동시에 곧바로 서비스를 사용할 수 있음. 
  * 이는 공유 자전거라는 서비스의 특성에 의해서 높은 가용성이 필요하다는 판단을 통해 내린 결정
  * 이때 결제를 비동기적으로 처리하기 위해서 반납 이후 30분 동안 재사용 시에는 반납 프로세스를 따르도록 함
  * 환승 프로세스로 인해서 사용자의 반납이 완전히 이뤄지지 않은 상태이기 때문에 비동기적으로 처리할 수 있음
