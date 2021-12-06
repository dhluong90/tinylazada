import fetch from "node-fetch";

const response = await fetch(
  "https://acs-m.lazada.sg/h5/mtop.lazada.homepage.service/1.0/?jsv=2.4.11&appKey=24677475&t=1638502180256&sign=e1625da4e20541b1af2bd5a3fd4793a9&api=mtop.lazada.homepage.service&v=1.0&timeout=8000&x-i18n-language=en&x-i18n-regionID=SG&dataType=json&type=originaljson&data=%7B%22language%22%3A%22en-SG%22%2C%22regionID%22%3A%22SG%22%2C%22platform%22%3A%22pc%22%2C%22userID%22%3A%22%22%2C%22anonUID%22%3A%22fbaa4659143a66389ae264eb3e08ba64%22%2C%22deviceID%22%3A%22%22%2C%22voyagerVersion%22%3A%222%22%2C%22pageNo%22%3A0%2C%22isbackup%22%3Atrue%2C%22backupParams%22%3A%22language%2CregionID%2Cplatform%2CpageNo%22%2C%22pcSlot%22%3A%22200%22%2C%22mobileSlot%22%3A%22200%22%2C%22appId%22%3A%22icms-zebra-5000357-2586207%22%2C%22_pvuuid%22%3A1638502179725%2C%22terminalType%22%3A1%7D",
  {
    headers: {
      accept: "application/json",
      "accept-language": "en-US,en;q=0.9,vi;q=0.8",
      "content-type": "application/x-www-form-urlencoded",
      "sec-ch-ua":
        '"Google Chrome";v="95", "Chromium";v="95", ";Not A Brand";v="99"',
      "sec-ch-ua-mobile": "?0",
      "sec-ch-ua-platform": '"macOS"',
      "sec-fetch-dest": "empty",
      "sec-fetch-mode": "cors",
      "sec-fetch-site": "same-site",
      cookie:
        "lzd_cid=47261694-2034-4246-9391-91a9f64344b5; t_uid=47261694-2034-4246-9391-91a9f64344b5; t_fv=1635035841130; cna=wZj7GZi+RzkCAXkH2oW/A1OR; _gcl_au=1.1.1144160411.1635035841; anon_uid=fbaa4659143a66389ae264eb3e08ba64; _fbp=fb.1.1635035842153.1322773393; lzd_sid=1fa90a27e290d31f7fd547f428e7b6d6; _tb_token_=3d43ee8776ebe; AMCVS_126E248D54200F960A4C98C6%40AdobeOrg=1; lzd_uid=1001946718; lzd_uti=%7B%22fpd%22%3A%222021-11-08%22%2C%22lpd%22%3A%222021-11-13%22%2C%22cnt%22%3A%2273%22%7D; cto_axid=I2Lv_-PnsXT0SBftIxgNSRudGupET8yV; hng=SG|en-SG|SGD|702; lzd_b_csg=830bff4a; _m_h5_tk=86c0d26ea5cf6d38f2c6aea50447796a_1638510313119; _m_h5_tk_enc=0e699beaf7bb78c841e8e86390df50ef; AMCV_126E248D54200F960A4C98C6%40AdobeOrg=-1124106680%7CMCIDTS%7C18965%7CMCMID%7C83596531204993301422782491223115916342%7CMCAAMLH-1639104674%7C3%7CMCAAMB-1639104674%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCOPTOUT-1638507074s%7CNONE%7CvVersion%7C5.2.0; xlly_s=1; t_sid=tQJHBeii730SzQTsmGHbf7G4gidVzH4a; utm_channel=NA; _uetsid=e1026f3053e311eca1bc49237e3d3fc4; _uetvid=8d097450346211eca17dcffd97dc2270; cto_bundle=mimD_V93akkwUldmMUJPTWNmQWJUdk1FaE5GcHFvNkJOJTJCaSUyRkpyUlQwdDZqTkJiJTJGS0swT3l6djhESzJ2cW9tJTJGMHM3c1RPeEZlekw5Yk5reGk0d1dTeHlsZVk3SHZsQVAwd1hhUmR0MEFtNFZEcW5sUnAlMkZiNGVjUFJVZHdhdXlmc1BwVXBKRko2MERRWmlJb3AlMkZKM2I2bFdGcFd5a0FZSXFlNGdBQnplTlVpSSUyRlJQT2MlMkJuaFNYMzRKT0thRW15Q0dWWVRI; isg=BEJCKfGbl7SnpIs1FgkUjm1Jk06kE0YtGc8YCoxbkbUt3-FZdKMzPXdej9Ojj77F; l=eBTGF2GHg1jYoLzTBO5wlurza77OWIRf1sPzaNbMiInca17fggTPCNCdf0Sezdtj_tfbKetPp737JRewJRaLSAkDBeYQO5OhL1p6-; tfstk=cVlPBiXQVWmf0DPBB7NeFpwJn_nRaguI71zLEYPsoWPG6aV0bs4Nvrq1MPzAuM2l.",
      Referer: "https://www.lazada.sg/",
      "Referrer-Policy": "strict-origin-when-cross-origin",
    },
    body: null,
    method: "GET",
  }
)
  .then((response) => response.json())
  .then((data) => {
    console.log(data);
    data.data.resultValue["icms-zebra-5000357-2586207"].each((item) => {
      console.log(item.itemImg);
    });
  });
