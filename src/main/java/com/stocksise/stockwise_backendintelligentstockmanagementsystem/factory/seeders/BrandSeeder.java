package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.seeders;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers.BrandFaker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.BrandRepository;
import org.springframework.stereotype.Component;

@Component
public class BrandSeeder {
    private final BrandFaker brandFaker;
    private final BrandRepository brandRepository;

    public BrandSeeder(BrandFaker brandFaker, BrandRepository brandRepository) {
        this.brandFaker = brandFaker;
        this.brandRepository = brandRepository;
    }

    public void run(){
        //create 20 brands
        brandRepository.save(brandFaker.create("Apple", "www.apple.com", "apple@gmail.com", true));
        brandRepository.save(brandFaker.create("Samsung", "www.samsung.com", "samsung@gmail.com", true));
        brandRepository.save(brandFaker.create("Dell", "www.dell.com", "dell@gmail.com", true));
        brandRepository.save(brandFaker.create("HP", "www.hp.com", "hp@gmail.com", true));
        brandRepository.save(brandFaker.create("Lenovo", "www.lenovo.com", "lenovo@gmail.com", true));
        brandRepository.save(brandFaker.create("Sony", "www.sony.com", "sony@gmail.com", true));
        brandRepository.save(brandFaker.create("LG", "www.lg.com", "lg@gmail.com", true));
        brandRepository.save(brandFaker.create("Acer", "www.acer.com", "acer@gmail.com", true));
        brandRepository.save(brandFaker.create("Asus", "www.asus.com", "asus@gmail.com", true));
        brandRepository.save(brandFaker.create("Toshiba", "www.toshiba.com", "toshiba@gmail.com", true));
        brandRepository.save(brandFaker.create("Microsoft", "www.microsoft.com", "microsoft@gmail.com", true));
        brandRepository.save(brandFaker.create("Nokia", "www.nokia.com", "nokia@gmail.com", true));
        brandRepository.save(brandFaker.create("Motorola", "www.motorola.com", "motorola@gmail.com", true));
        brandRepository.save(brandFaker.create("Blackberry", "www.blackberry.com", "blackberry@gmail.com", true));
        brandRepository.save(brandFaker.create("HTC", "www.htc.com", "htc@gmail.com", true));
        brandRepository.save(brandFaker.create("Huawei", "www.huawei.com", "huawei@gmail.com", true));
    }
}
