package com.example.teacherkotlinproject.model

data class Publication(
    var id: Int,
    var icon: String,
    var name: String,
    var phoneNumber: String,
    var age: Int,
    var image: MutableList<String>,
    val randomImage: String,
    var isFavorite: Boolean = false
)

val imagesArray = mutableListOf<String>().apply {
    add("https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png")
    add("https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/article_thumbnails/other/cat_relaxing_on_patio_other/1800x1200_cat_relaxing_on_patio_other.jpg")
    add("https://www.study.ru/uploads/server/YNUzTtg0hUDiTWiP.jpg")
}

val publicationsArray = mutableListOf<Publication>().apply {
    add(Publication(1,"https://cdnimg.rg.ru/img/content/179/91/88/1_d_850.jpg","John", "999777222107", 30, imagesArray, imagesArray.random()))
    add(Publication(2, "https://img.tyt.by/n/afisha/0c/10/dzhonni_depp_00332.jpg","Sara", "999777222111", 35, imagesArray, imagesArray.random()))
    add(Publication(3, "https://www.letoile.ru/upload/iblock/e92/753c1d2e34e27aa0481155da1bc82aac.jpg","Andry", "999777555333", 29, imagesArray, imagesArray.random()))
    add(Publication(4,"https://static.mk.ru/upload/entities/2019/03/24/13/articles/detailPicture/ea/a9/26/3b/9cc279b0d24fd1faaa71d5a781946a1a.jpg", "German", "999777555112", 40, imagesArray, imagesArray.random()))
    add(Publication(5,"https://www.ok-magazine.ru/images/cache/2019/1/3/fit_795_547_false_crop_2126_1417_0_0_q90_54721_2907188c9cca011c80ff98c94.jpeg","Klara", "999777234198", 25, imagesArray, imagesArray.random()))
    add(Publication(6,"https://icdn.lenta.ru/images/2019/11/03/16/20191103163828946/square_320_8efac95ef69dfd64f33624a1f650fcf6.jpg","Anna", "999777222111", 40, imagesArray, imagesArray.random()))
    add(Publication(7,"https://wl-adme.cf.tsp.li/resize/728x/jpg/5b7/861/0811805d509434dd2123670546.jpg","Jinny", "999777242106", 49, imagesArray, imagesArray.random()))
    add(Publication(7,"https://wl-adme.cf.tsp.li/resize/728x/jpg/5b7/861/0811805d509434dd2123670546.jpg","Jinny", "999777242106", 49, imagesArray, imagesArray.random()))
    add(Publication(7,"https://wl-adme.cf.tsp.li/resize/728x/jpg/5b7/861/0811805d509434dd2123670546.jpg","Jinny", "999777242106", 49, imagesArray, imagesArray.random()))
    add(Publication(7,"https://wl-adme.cf.tsp.li/resize/728x/jpg/5b7/861/0811805d509434dd2123670546.jpg","Jinny", "999777242106", 49, imagesArray, imagesArray.random()))
}