<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<%@ include file="basic.jsp"%>
<h1 style="color: whitesmoke;">My Cart</h1>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-4 my-3">
            <div class="bg-mattBlackLight px-3 py-3">
                <h4 class="mb-2">Mobile 1</h4>
                <img src ="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRYpBYTOJj7u-N8BNZu3GOMOi7cIdKcIHu9RX3lMNlGxtMcwUqEQOEYWpuASQ&usqp=CAc">
                <ul class="des" TYPE="disc">
                    <li>
                        36MP Dual camera
                    </li>
                    <li>
                        14cm (5.9) Dot Notch Display
                    </li>
                    <li>
                        4400mAh Battery
                    </li>
                    <li>
                        Processor : Snapdragon Octa-Core
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-md-4 my-3">
            <div class="bg-mattBlackLight px-3 py-3">
                <h4 class="mb-2">Mobile 2</h4>
                <img src="data:image/jpeg;base64,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">
                <ul TYPE="disc">
                    <li>
                        36MP Dual camera
                    </li>
                    <li>
                        14cm (5.9) Dot Notch Display
                    </li>
                    <li>
                        4400mAh Battery
                    </li>
                    <li>
                        Processor : Snapdragon Octa-Core
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-md-4 my-3">
            <div class="bg-mattBlackLight p-3">
                <h4 class="mb-2">Mobile 3</h4>
                <div>
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ_uVRlVoXtO90_PHFOhDQl6TIiTw-7lWabFmuTdQ6jHNBNF8ZwKEg7PAPtkg&usqp=CAc">
                    <ul class="des" TYPE="disc">
                        <li>
                            48MP Dual camera
                        </li>
                        <li>
                            16cm (6.3) Dot Notch Display
                        </li>
                        <li>
                            4000mAh Battery
                        </li>
                        <li>
                            Processor : Snapdragon Octa-Core
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-4 my-3">
            <div class="bg-mattBlackLight p-3">
                <h4 class="mb-2">Mobile 4</h4>
                <div>
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ_uVRlVoXtO90_PHFOhDQl6TIiTw-7lWabFmuTdQ6jHNBNF8ZwKEg7PAPtkg&usqp=CAc">
                    <ul class="des" TYPE="disc">
                        <li>
                            48MP Dual camera
                        </li>
                        <li>
                            16cm (6.3) Dot Notch Display
                        </li>
                        <li>
                            4000mAh Battery
                        </li>
                        <li>
                            Processor : Snapdragon Octa-Core
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-4 my-3">
            <div class="bg-mattBlackLight px-3 py-3">
                <h4 class="mb-2">Mobile 2</h4>
                <img src="data:image/jpeg;base64,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">
                <ul class="des" TYPE="disc">
                    <li>
                        36MP Dual camera
                    </li>
                    <li>
                        14cm (5.9) Dot Notch Display
                    </li>
                    <li>
                        4400mAh Battery
                    </li>
                    <li>
                        Processor : Snapdragon Octa-Core
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>





</main>
</div>
</div>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"
></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.bundle.min.js"
        integrity="sha256-OUFW7hFO0/r5aEGTQOz9F/aXQOt+TwqI1Z4fbVvww04="
        crossorigin="anonymous"
></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jQuery-slimScroll/1.3.8/jquery.slimscroll.min.js"
        integrity="sha256-qE/6vdSYzQu9lgosKxhFplETvWvqAAlmAuR+yPh/0SI="
        crossorigin="anonymous"
></script>
<script src="./js/script.js"></script>
</body>
</html>

</body>
</html>

</body>
</html>
