package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.*;

@Controller

@RequestMapping("/home")
public class HomeController {

    @RequestMapping({"calculator"})
    public String register() {
        return "Calculator";
    }

        @RequestMapping({"/tax"})
            public String calculation(@ModelAttribute("bsal") int bsal,
                                      @ModelAttribute("hrent") int hrent,
                                      @ModelAttribute("medical") int medical,
                                      @ModelAttribute("conv") int conv,
                                      @ModelAttribute("bonus") int bonus,
                                      @ModelAttribute("category") String category,
                                      Model model) throws SQLException {
            int total =0;
            int total1 =0;
            int tconv = 0;
            int trent = 0;
            int tmed = 0;
            int taxable = 0;
            if(bsal>=0 || hrent>=0 || medical>=0 || conv>=0 || bonus>=0) {
                total1 = (bsal*12) + (hrent*12) + (medical*12)+ (conv*12) + (bonus*2) ;
                if (conv * 12 > 30000) {
                    tconv = (conv * 12) - 30000;
                }
                if (bsal * 6 > 300000) {
                    trent = hrent * 12 - 300000;
                } else {
                    trent = hrent * 12 - bsal * 6;
                }
                if (((bsal * 12) * 10) / 100 > 120000) {
                    tmed = medical * 12 - 1200000;
                } else {
                    tmed = medical * 12 - ((bsal * 12) * 10) / 100;
                }
                total = tconv + trent + tmed + (bonus * 2) + (bsal * 12);
            }

            taxable = total;

            int tax1 = 0;
            int tax2 = 0;
            int tax3 = 0;
            int tax4 = 0;
            int tax5 = 0;

          if(category.equals("General")) {
              if (total > 300000) {
                  total = total - 300000;

                  if (total > 100000) {
                      total = total - 100000;
                      tax1 = 100000 * 5 / 100;

                      if (total > 300000) {
                          total = total - 300000;
                          tax2 = 300000 * 10 / 100;

                          if (total > 400000) {
                              total = total - 400000;
                              tax3 = 400000 * 15 / 100;

                              if (total > 500000) {
                                  total = total - 500000;
                                  tax4 = 500000 * 20 / 100;

                                  if (total >= 1) {
                                      tax5 = total * 25 / 100;
                                  }
                              } else {
                                  tax4 = total * 20 / 100;
                              }
                          } else {
                              tax3 = total * 15 / 100;
                          }
                      } else {
                          tax2 = total * 10 / 100;
                      }
                  } else {
                      tax1 = total * 5 / 100;
                  }
              }
          }

            else if(category.equals("Female/Senior Citizen")) {
                if (total > 350000) {
                    total = total - 350000;

                    if (total > 100000) {
                        total = total - 100000;
                        tax1 = 100000 * 5 / 100;

                        if (total > 300000) {
                            total = total - 300000;
                            tax2 = 300000 * 10 / 100;

                            if (total > 400000) {
                                total = total - 400000;
                                tax3 = 400000 * 15 / 100;

                                if (total > 500000) {
                                    total = total - 500000;
                                    tax4 = 500000 * 20 / 100;

                                    if (total >= 1) {
                                        tax5 = total * 25 / 100;
                                    }
                                } else {
                                    tax4 = total * 20 / 100;
                                }
                            } else {
                                tax3 = total * 15 / 100;
                            }
                        } else {
                            tax2 = total * 10 / 100;
                        }
                    } else {
                        tax1 = total * 5 / 100;
                    }
                }
            }

            else if(category.equals("Freedom Fighter")) {
                if (total > 375000) {
                    total = total - 375000;

                    if (total > 100000) {
                        total = total - 100000;
                        tax1 = 100000 * 5 / 100;

                        if (total > 300000) {
                            total = total - 300000;
                            tax2 = 300000 * 10 / 100;

                            if (total > 400000) {
                                total = total - 400000;
                                tax3 = 400000 * 15 / 100;

                                if (total > 500000) {
                                    total = total - 500000;
                                    tax4 = 500000 * 20 / 100;

                                    if (total >= 1) {
                                        tax5 = total * 25 / 100;
                                    }
                                } else {
                                    tax4 = total * 20 / 100;
                                }
                            } else {
                                tax3 = total * 15 / 100;
                            }
                        } else {
                            tax2 = total * 10 / 100;
                        }
                    } else {
                        tax1 = total * 5 / 100;
                    }
                }
            }

            int tax = tax1+tax2+tax3+tax4+tax5;

            model.addAttribute("tax", tax);
            model.addAttribute("taxable", taxable);
            model.addAttribute("total1", total1);

            return "Tax";
    }
}

