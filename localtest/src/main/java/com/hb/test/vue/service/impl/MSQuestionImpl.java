package com.hb.test.vue.service.impl;

import com.hb.test.vue.ms.model.MSAnswer;
import com.hb.test.vue.ms.model.MSMarker;
import com.hb.test.vue.ms.model.MSQuestion;
import com.hb.test.vue.service.MSQuestionService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MSQuestionImpl<T> implements MSQuestionService {

    @Override
    public List search(MSQuestion condition) {
        return Data.datas;
    }

    @Override
    public List searchByMame(String name) {
        if(StringUtils.isEmpty(name))
            return Data.datas;
        return Data.datas.stream().filter(item -> {
            if(item.getContent().contains(name))
                return true;
            return false;
        }).collect(Collectors.toList());
    }
}

class Data{
    public static List<MSQuestion> datas = new ArrayList<>();

    static {
        List<MSMarker> ms = new ArrayList<>();
        ms.add(new MSMarker("1", "aaa"));
        ms.add(new MSMarker("2", "bbb"));
        ms.add(new MSMarker("3", "ccc"));
        ms.add(new MSMarker("4", "ddd"));
        ms.add(new MSMarker("5", "eee"));
        ms.add(new MSMarker("6", "fff"));
        ms.add(new MSMarker("7", "ggg"));

        List<MSAnswer> ans = new ArrayList<>();
        ans.add(new MSAnswer("1", "按时aaa", radomList(ms)));
        ans.add(new MSAnswer("2", "按时bbb", radomList(ms)));
        ans.add(new MSAnswer("3", "按时ccc", radomList(ms)));
        ans.add(new MSAnswer("4", "按时ddd", radomList(ms)));
        ans.add(new MSAnswer("5", "按时eee", radomList(ms)));

        datas.add(new MSQuestion("1", "为什么1不是1？", radomList(ans), radomList(ms)));
        datas.add(new MSQuestion("2", "为什么2不是2？", radomList(ans), radomList(ms)));
        datas.add(new MSQuestion("3", "为什么3不是3？", radomList(ans), radomList(ms)));
        datas.add(new MSQuestion("4", "为什么4不是4？", radomList(ans), radomList(ms)));

    }

    public static <T> List<T> radomList(List<T> list){
        int[] idx = randomNums(list.size());
        List<T> rst = new ArrayList<T>();
        for (int i = 0; i < idx.length; i++) {
            rst.add(list.get(idx[i]));
        }
        return rst;
    }

    public static int[] randomNums(int maxNum){
        int len = (int)(Math.random() * (maxNum - 2)) + 2;
        int[] rst = new int[len];
        for (int i = 0; i < len; i++) {
            rst[i] = (int) (Math.random() * maxNum);
        }
        return rst;
    }

    public static void main(String[] args) {
        for (int i = 0; i < datas.size() ; i++) {
            System.out.println(datas.get(i));
            System.out.println("------------------");
        }
    }
}