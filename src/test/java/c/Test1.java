package c;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

import static com.alibaba.fastjson.JSON.parseObject;
import static com.alibaba.fastjson.JSON.toJSONString;
import static java.util.regex.Pattern.compile;

public class Test1 {

	public static void main(String[] args) throws ClassNotFoundException {

		String jsonStr = "{\"boxComputes\":[{\"bearing\":29950.0000,\"freeBearing\":29950.0000,\"freeVolume\":787.500,\"innerHeight\":3.5,\"innerLength\":20.0,\"innerWidth\":15.0,\"lengthUnit\":\"cm\",\"multiMaxVolume\":787.500,\"multiWarningVolume\":682.500,\"packageCode\":\"EPAR01\",\"packageHeight\":4.2,\"packageLength\":21.8,\"packageName\":\"e-Parcel-1\",\"packageType\":2,\"packageWeight\":50.000,\"packageWeightUnit\":\"g\",\"packageWidth\":15.2,\"singleUsefulVolume\":840.000,\"skuInfoMap\":{},\"totalFee\":0,\"usefulBodyDiagonalSquare\":357.21,\"volume\":1050.000,\"volumeUnit\":\"CBC\"},{\"bearing\":29881.0000,\"freeBearing\":29881.0000,\"freeVolume\":2598.156,\"innerHeight\":4.4,\"innerLength\":32.4,\"innerWidth\":24.3,\"lengthUnit\":\"cm\",\"multiMaxVolume\":2598.156,\"multiWarningVolume\":2251.735,\"packageCode\":\n" +
				"\"EPAR02\",\"packageHeight\":5.0,\"packageLength\":35.3,\"packageName\":\"e-Parcel-2\",\"packageType\":2,\"packageWeight\":119.000,\"packageWeightUnit\":\"g\",\"packageWidth\":25.0,\"singleUsefulVolume\":2771.366,\"skuInfoMap\":{},\"totalFee\":0,\"usefulBodyDiagonalSquare\":930.25,\"volume\":3464.208,\"volumeUnit\":\"CBC\"},{\"bearing\":29893.0000,\"freeBearing\":29893.0000,\"freeVolume\":3469.047,\"innerHeight\":10.1,\"innerLength\":21.4,\"innerWidth\":21.4,\"lengthUnit\":\"cm\",\"multiMaxVolume\":3469.047,\"multiWarni\n" +
				"ngVolume\":3006.507,\"packageCode\":\"EPAR03\",\"packageHeight\":11.3,\"packageLength\":22.0,\"packageName\":\"e-Parcel-3\",\"packageType\":2,\"packageWeight\":107.000,\"packageWeightUnit\":\"g\",\"packageWidth\":22.0,\"singleUsefulVolume\":3931.587,\"skuInfoMap\":{},\"totalFee\":0,\"usefulBodyDiagonalSquare\":571.21,\"volume\":4625.396,\"volumeUnit\":\"CBC\"},{\"bearing\":29762.0000,\"freeBearing\":29762.0000,\"freeVolume\":10428.684,\"innerHeight\":10.9,\"innerLength\":35.7,\"innerWidth\":33.5,\"lengthUnit\":\"cm\",\"multiMaxVolume\":10428.684,\"multiWarningVolume\":9125.099,\"packageCode\":\"EPAR04\",\"packageHeight\":12.1,\"packageLength\":36.3,\"packageName\":\"e-Parcel-4\",\"packageType\":2,\"packageWeight\":238.000,\"packageWeightUnit\":\"g\",\"packageWidth\":34.1,\"singleUsefulVolume\":11080.477,\"skuInfoMap\":{},\"totalFee\":0,\"usefulBodyDiagonalSquare\":1616.04,\"volume\":13035.855,\"volumeUnit\":\"CBC\"},{\"bearing\":29623.0000,\"freeBearing\":29623.0000,\"freeVolume\":21251.558,\"innerHeight\":13.8,\"innerLength\":45.4,\"innerWidth\":42.4,\"lengthUnit\":\"cm\",\"multiMaxVolume\":21251.558,\"multiWarningVolume\":18595.114,\"packageCode\":\"EPAR05\",\"packageHeight\":15.0,\"packageLength\":46.0,\"packageName\":\"e-Parcel-5\",\"packageType\":2,\"packageWeight\":377.000,\"packageWeightUnit\":\"g\",\"packageWidth\":43.0,\"singleUsefulVolume\":22579.781,\"skuInfoMap\":{},\"totalFee\":0,\"usefulBodyDiagonalSquare\":2590.81,\"volume\":26564.448,\"volumeUnit\":\"CBC\"},{\"bearing\":29653.0000,\"freeBearing\":29653.0000,\"freeVolume\":32678.712,\"innerHeight\":33.0,\"innerLength\":36.3,\"innerWidth\":34.1,\"lengthUnit\":\"cm\",\"multiMaxVolume\":32678.712,\"multiWarningVolume\":28593.873,\"packageCode\":\"EPAR06\",\"packageHeight\":34.6,\"packageLength\":37.1,\"packageName\":\"e-Parcel-6\",\"packageType\":2,\"packageWeight\":347.000,\"packageWeightUnit\":\"g\",\"packageWidth\":34.9,\"singleUsefulVolume\":34721.132,\"skuInfoMap\":{},\"totalFee\":0,\"usefulBodyDiagonalSquare\":2284.84,\"volume\":40848.390,\"volumeUnit\":\"CBC\"},{\"bearing\":29205.0000,\"freeBearing\":29205.0000,\"freeVolume\":50655.533,\"innerHeight\":22.9,\"innerLength\":56.2,\"innerWidth\":49.2,\"lengthUnit\":\"cm\",\"multiMaxVolume\":50655.533,\"multiWarningVolume\":44323.591,\"packageCode\":\"EPAR07\",\"packageHeight\":24.5,\"packageLength\":57.0,\"packageName\":\"e-Parcel-7\",\"packageType\":2,\"packageWeight\":795.000,\"packageWeightUnit\":\"g\",\"packageWidth\":50.0,\"singleUsefulVolume\":53821.504,\"skuInfoMap\":{},\"totalFee\":0,\"usefulBodyDiagonalSquare\":3906.25,\"volume\":63319.416,\"volumeUnit\":\"CBC\"},{\"bearing\":28696.0000,\"freeBearing\":28696.0000,\"freeVolume\":112320.000,\"innerHeight\":40.0,\"innerLength\":78.0,\"innerWidth\":45.0,\"lengthUnit\":\"cm\",\"multiMaxVolume\":112320.000,\"multiWarningVolume\":98280.000,\"packageCode\":\"EPAR08\",\"packageHeight\":41.6,\"packageLength\":80.8,\"packageName\":\"e-Parcel-8\",\"packageType\":2,\"packageWeight\":1304.000,\"packageWeightUnit\":\"g\",\"packageWidth\":47.8,\"singleUsefulVolume\":119340.000,\"skuInfoMap\":{},\"totalFee\":0,\"usefulBodyDiagonalSquare\":6209.44,\"volume\":140400.000,\"volumeUnit\":\"CBC\"},{\"bearing\":29000.0000,\"freeBearing\":29000.0000,\"freeVolume\":67001.600,\"innerHeight\":38.0,\"innerLength\":58.0,\"innerWidth\":38.0,\"lengthUnit\":\"cm\",\"multiMaxVolume\":67001.600,\"multiWarningVolume\":58626.400,\"packageCode\":\"EPAR09\",\"packageHeight\":40.0,\"packageLength\":60.0,\"packageName\":\"e-Parcel-9\",\"packageType\":2,\"packageWeight\":1000.000,\"packageWeightUnit\":\"g\",\"packageWidth\":40.0,\"singleUsefulVolume\":71189.200,\"skuInfoMap\":{},\"totalFee\":0,\"usefulBodyDiagonalSquare\":4006.89,\"volume\":83752.000,\"volumeUnit\":\"CBC\"},{\"bearing\":31500.0000,\"freeBearing\":31500.0000,\"freeVolume\":78000.000,\"innerHeight\":60.0,\"innerLength\":50.0,\"innerWidth\":40.0,\"lengthUnit\":\"cm\",\"multiMaxVolume\":78000.000,\"multiWarningVolume\":90000.000,\"packageCode\":\"EPARTEST02\",\"packageHeight\":61.0,\"packageLength\":51.0,\"packageName\":\"DummyTest<E7><BA><B8><E7><AE><B1><EF><BC><88>514161<EF><BC><89>\",\"packageType\":2,\"packageWeight\":1200.000,\"packageWeightUnit\":\"g\",\"packageWidth\":41.0,\"singleUsefulVolume\":96000.000,\"skuInfoMap\":{},\"totalFee\":0,\"usefulBodyDiagonalSquare\":4329.64,\"volume\":120000.000,\"volumeUnit\":\"CBC\"}],\"bubbleBagComputes\":[{\"bearing\":977.0000,\"freeBearing\":977.0000,\"freeVolume\":3500.000,\"innerHeight\":4.0,\"innerLength\":35.0,\"innerWidth\":25.0,\"lengthUnit\":\"cm\",\"multiMaxVolume\":3500.000,\"multiWarningVolume\":3500.000,\"packageCode\":\"EBAG01\",\"packageHeight\":5.0,\"packageLength\":35.0,\"packageName\":\"e-Bubble-1\",\"packageType\":1,\"packageWeight\":23.000,\"packageWeightUnit\":\"g\",\"packageWidth\":25.0,\"singleUsefulVolume\":3500.000,\"skuInfoMap\":{},\"totalFee\":0,\"volume\":4375.000,\"volumeUnit\":\"CBC\"}],\"multiSkuBoxMatrix\":" +
				"{\"xAxis\":{\"OC0100000136429\":{\"key\":\"OC0100000136429\",\"relatedNodes\":{\"EPAR08\":{\"key\":\"EPAR08\",\"relatedNodes\":{\"OC0100000136429\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"key\":\"OC0100000148126\",\"relatedNodes\":{\"EPAR08\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08\"},\"EPAR09\":{\"key\":\"EPAR09\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.multiSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.multiSkuB\n" +
				"oxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"singleRelation\":false,\"value\":{\"bearing\":29000.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[8]\"},\"packages\":[],\"usefulVolume\":67001.600,\"volume\":83752.00" +
				"0}},\"EPARTEST02\":{\"key\":\"EPARTEST02\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.multiSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC01000001" +
				"48126\"}},\"singleRelation\":false,\"value\":{\"bearing\":31500.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[9]\"},\"packages\":[],\"usefulVolume\":78000.000,\"volume\":120000.000}},\"EPAR04\":{\"key\":\"EPAR04\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$" +
				".multiSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"singleRelation\":false,\"value\":{\"bearing\":29762.0000,\"packageOrigin\":{\"$" +
				"ref\":\"$.boxComputes[3]\"},\"packages\":[],\"usefulVolume\":10428.684,\"volume\":13035.855}},\"EPAR05\":{\"key\":\"EPAR05\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.multiSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.multiSkuBo" +
				"xMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"singleRelation\":false,\"value\":{\"bearing\":29623.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[4]\"},\"packages\":[],\"usefulVolume\":21251.558,\"volume\":26564.448" +
				"}},\"EPAR06\":{\"key\":\"EPAR06\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.multiSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}}," +
				"\"singleRelation\":false,\"value\":{\"bearing\":29653.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[5]\"},\"packages\":[],\"usefulVolume\":32678.712,\"volume\":40848.390}},\"EPAR07\":{\"key\":\"EPAR07\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.multiSkuB" +
				"oxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"singleRelation\":false,\"value\":{\"bearing\":29205.0000,\"packageOrigin\":{\"$ref\":\"$.bo" +
				"xComputes[6]\"},\"packages\":[],\"usefulVolume\":50655.533,\"volume\":63319.416}},\"EPAR01\":{\"key\":\"EPAR01\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.multiSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.multiSkuBoxMatrix.xA" +
				"xis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"singleRelation\":false,\"value\":{\"bearing\":29950.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[0]\"},\"packages\":[],\"usefulVolume\":787.500,\"volume\":1050.000}},\"EPAR02\":{" +
				"\"key\":\"EPAR02\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.multiSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"singleRelati" +
				"on\":false,\"value\":{\"bearing\":29881.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[1]\"},\"packages\":[],\"usefulVolume\":2598.156,\"volume\":3464.208}},\"EPAR03\":{\"key\":\"EPAR03\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.multiSkuBoxMatrix.xAxis." +
				"OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"singleRelation\":false,\"value\":{\"bearing\":29893.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[2]\"}," +
				"\"packages\":[],\"usefulVolume\":3469.047,\"volume\":4625.396}}},\"singleRelation\":false,\"value\":{\"skuOrigin\":{\"hasBattery\":false,\"height\":1,\"length\":1,\"lengthUnit\":\"cm\",\"longestEdgeSquare\":1,\"ownPackage\":false,\"pureBattery\":false,\"quantity\":1" +
				",\"sellerSkuId\":\"s241\",\"skuId\":\"OC0100000148126\",\"skuName\":\"s241\",\"transactionAmount\":0,\"transactionCurrency\":\"\",\"volume\":1,\"weight\":20000.00,\"weightUnit\":\"g\",\"width\":1},\"unpackedQuantity\":1,\"volume\":1,\"weight\":20000.00}}},\"singleRelatio" +
				"n\":false,\"value\":{\"bearing\":28696.0000,\"packageOrigin\":{\"ref\":\".boxComputes[7]\"},\"packages\":[],\"usefulVolume\":112320.000,\"volume\":140400.000}},\"EPAR09\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNode" +
				"s.OC0100000148126.relatedNodes.EPAR09\"},\"EPARTEST02\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPARTEST02\"},\"EPAR04\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC01000001364" +
				"29.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR04\"},\"EPAR05\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR05\"},\"EPAR06\":{\"ref\":\".multiSkuBox" +
				"Matrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR06\"},\"EPAR07\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR07\"},\"EPAR" +
				"01\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR01\"},\"EPAR02\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.r" +
				"elatedNodes.EPAR02\"},\"EPAR03\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR03\"}},\"singleRelation\":false,\"value\":{\"skuOrigin\":{\"hasBattery\":false,\"height\":1,\"length\"" +
				":1,\"lengthUnit\":\"cm\",\"longestEdgeSquare\":1,\"ownPackage\":false,\"pureBattery\":false,\"quantity\":1,\"sellerSkuId\":\"s422\",\"skuId\":\"OC0100000136429\",\"skuName\":\"s422\",\"transactionAmount\":0,\"transactionCurrency\":\"\",\"volume\":1,\"weight\":20000.00,\"" +
				"weightUnit\":\"g\",\"width\":1},\"unpackedQuantity\":1,\"volume\":1,\"weight\":20000.00}},\"OC0100000148126\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"yAxis\":{\"EPAR08\":{\"ref\":\".multiSk" +
				"uBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08\"},\"EPAR09\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR09\"},\"EPARTEST02\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC" +
				"0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPARTEST02\"},\"EPAR04\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR04\"},\"EPAR05\":{\"ref\"" +
				":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR05\"},\"EPAR06\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes" +
				".EPAR06\"},\"EPAR07\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR07\"},\"EPAR01\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC" +
				"0100000148126.relatedNodes.EPAR01\"},\"EPAR02\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR02\"},\"EPAR03\":{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNo" +
				"des.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR03\"}}},\"ownPackageMatrix\":{\"xAxis\":{},\"yAxis\":{}},\"singleSkuBoxMatrix\":{\"xAxis\":{\"OC0100000136429\":{\"key\":\"OC0100000136429\",\"relatedNodes\":{\"EPAR08\":{\"key\":\"EPAR08\",\"relatedNodes\"" +
				":{\"OC0100000136429\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"key\":\"OC0100000148126\",\"relatedNodes\":{\"EPAR08\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08\"},\"EPAR09\":{\"key\":\"EPAR09\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"singleRelation\":false,\"value\":{\"bearing\":29000.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[8]\"},\"packages\":[],\"usefulVolume\":67001.600,\"volume\":83752.000}},\"EPARTEST02\":{\"key\":\"EPARTEST02\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"singleRelation\":false,\"value\":{\"bearing\":31500.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[9]\"},\"packages\":[],\"usefulVolume\":78000.000,\"volume\":120000.000}},\"EPAR04\":{\"key\":\"EPAR04\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"singleRelation\":false,\"value\":{\"bearing\":29762.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[3]\"},\"packages\":[],\"usefulVolume\":10428.684,\"volume\":13035.855}},\"EPAR05\":{\"key\":\"EPAR05\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"singleRelation\":false,\"value\":{\"bearing\":29623.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[4]\"},\"packages\":[],\"usefulVolume\":21251.558,\"volume\":26564.448}},\"EPAR06\":{\"key\":\"EPAR06\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"singleRelation\":false,\"value\":{\"bearing\":29653.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[5]\"},\"packages\":[],\"usefulVolume\":32678.712,\"volume\":40848.390}},\"EPAR07\":{\"key\":\"EPAR07\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"singleRelation\":false,\"value\":{\"bearing\":29205.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[6]\"},\"packages\":[],\"usefulVolume\":50655.533,\"volume\":63319.416}},\"EPAR01\":{\"key\":\"EPAR01\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"singleRelation\":false,\"value\":{\"bearing\":29950.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[0]\"},\"packages\":[],\"usefulVolume\":787.500,\"volume\":1050.000}},\"EPAR02\":{\"key\":\"EPAR02\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"singleRelation\":false,\"value\":{\"bearing\":29881.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[1]\"},\"packages\":[],\"usefulVolume\":2598.156,\"volume\":3464.208}},\"EPAR03\":{\"key\":\"EPAR03\",\"relatedNodes\":{\"OC0100000136429\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429\"},\"OC0100000148126\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"singleRelation\":false,\"value\":{\"bearing\":29893.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[2]\"},\"packages\":[],\"usefulVolume\":3469.047,\"volume\":4625.396}}},\"singleRelation\":false,\"value\":{\"skuOrigin\":{\"$ref\":\"$.multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.value.skuOrigin\"},\"unpackedQuantity\":1,\"volume\":1,\"weight\":20000.00}}},\"singleRelation\":false,\"value\":{\"bearing\":28696.0000,\"packageOrigin\":{\"$ref\":\"$.boxComputes[7]\"},\"packages\":[],\"usefulVolume\":112320.000,\"volume\":140400.000}},\"EPAR09\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR09\"},\"EPARTEST02\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPARTEST02\"},\"EPAR04\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR04\"},\"EPAR05\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR05\"},\"EPAR06\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR06\"},\"EPAR07\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR07\"},\"EPAR01\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR01\"},\"EPAR02\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR02\"},\"EPAR03\":{\"$ref\":\"$.singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR03\"}},\"singleRelation\":false,\"value\":{\"skuOrigin\":{\"$ref\":\"$.multiSkuBoxMatrix.xAxis.OC0100000136429.value.skuOrigin\"},\"unpackedQuantity\":1,\"volume\":1,\"weight\":20000.00}},\"OC0100000148126\":{\"ref\":\".singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126\"}},\"yAxis\":{\"EPAR08\":{\"ref\":\".singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08\"},\"EPAR09\":{\"ref\":\".singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR09\"},\"EPARTEST02\":{\"ref\":\".singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPARTEST02\"},\"EPAR04\":{\"ref\":\".singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR04\"},\"EPAR05\":{\"ref\":\".singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR05\"},\"EPAR06\":{\"ref\":\".singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR06\"},\"EPAR07\":{\"ref\":\".singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR07\"},\"EPAR01\":{\"ref\":\".singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR01\"},\"EPAR02\":{\"ref\":\".singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR02\"},\"EPAR03\":{\"ref\":\".singleSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.relatedNodes.EPAR03\"}}},\"singleSkuBubbleBagMatrix\":{\"xAxis\":{},\"yAxis\":{}},\"skuComputes\":[{\"ref\":\".multiSkuBoxMatrix.xAxis.OC0100000136429.relatedNodes.EPAR08.relatedNodes.OC0100000148126.value.skuOrigin\"},{\"ref\":\"$.multiSkuBoxMatrix.xAxis.OC0100000136429.value.skuOrigin\"}],\"skuComputesRemain\":[{\"hasBattery\":false,\"height\":1,\"length\":1,\"lengthUnit\":\"cm\",\"longestEdgeSquare\":1,\"ownPackage\":false,\"pureBattery\":false,\"quantity\":1,\"sellerSkuId\":\"s241\",\"skuId\":\"OC0100000148126\",\"skuName\":\"s241\",\"transactionAmount\":0,\"transactionCurrency\":\"\",\"volume\":1,\"weight\":20000.00,\"weightUnit\":\"g\",\"width\":1},{\"hasBattery\":false,\"height\":1,\"length\":1,\"lengthUnit\":\"cm\",\"longestEdgeSquare\":1,\"ownPackage\":false,\"pureBattery\":false,\"quantity\":1,\"sellerSkuId\":\"s422\",\"skuId\":\"OC0100000136429\",\"skuName\":\"s422\",\"transactionAmount\":0,\"transactionCurrency\":\"\",\"volume\":1,\"weight\":20000.00,\"weightUnit\":\"g\",\"width\":1}]}";
		JSONObject jsonObject = parseObject(jsonStr);

		System.out.println(jsonObject.toJSONString());
//		String jsonString = toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
//
//		System.out.println(jsonString);
	}

}
