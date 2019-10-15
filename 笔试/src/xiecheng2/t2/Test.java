//#include <stdio.h>
//        #include <malloc.h>
//        #include <string.h>
//        #include <stdlib.h>
//
//        #define MENU_NAME_LEN 42
//
//        #define Q5_TRUE 1
//        #define Q5_FALSE 0
//
//        #define Q5_UNUSED_ITEM 600
//
//        long g_arrReference[300];     /* [lM] */
//        long g_arrPeople[300][300];   /* [lM][lN] */
//
//        long g_arrPermitted[300];     /* [lN] */
//        long g_arrAreaList[300][300]; /* [lN][lM] */
//        long g_arrSolution[300][300]; /* [lN][lM] */
//
//        long g_arrDupList[300][301];  /* [lM][1 + lDupCnt] */
//
//        long g_lCntSort;
//
//        char * ReadInt(char * sz, long * out)
//        {
//            long i;
//            long lPos;
//            char szBuf[100];
//
//            for (i = 0; ' ' == sz[i]; i++)
//            {
//                /* nothing */
//            }
//
//            lPos = i;
//
//            for (; sz[i] && ' ' != sz[i]; i++)
//            {
//                /* nothing */
//            }
//
//            strncpy(szBuf, sz + lPos, i - lPos);
//            szBuf[i - lPos] = '/0';
//            *out = atol(szBuf);
//
//            return sz + i;
//        }
//
//        long compare( const void *arg1, const void *arg2)
//        {
//            return g_arrPeople[*(long*)arg1][g_lCntSort] < g_arrPeople[*(long*)arg2][g_lCntSort];
//        }
//
//        long GetTotal(long lN, long lM)
//        {
//            long lTotal = 0;
//            long i, j;
//
//            for (i = 0; i < lN; i++)
//            {
//                for (j = 0; j < g_arrPermitted[i]; j++)
//                {
//                    lTotal += g_arrPeople[g_arrAreaList[i][j]][i];
//                }
//            }
//
//            return lTotal;
//        }
//
//        long GetSwapResult(long lN, long lM, long lKey)
//        {
//            long i, j;
//            long lMaxCost = -1;
//            long lCost = 0;
//            long lMaxTotal = 0;
//            long lIndex = 0;
//            long lPermitted;
//            long arrKeyToSwap[300][2]; /* [lN] */
//            long lTemp;
//            long lDupCnt = 0;
//            long lOldCnt;
//            char bDecided = Q5_FALSE;
//
//            for (i = 0; i < g_arrDupList[lKey][0]; i++)
//            {
//                lPermitted = g_arrPermitted[g_arrDupList[lKey][i + 1]];
//
//                for (j = 0; j < lPermitted; j++)
//                {
//                    if (g_arrAreaList[g_arrDupList[lKey][i + 1]][j] == lKey)
//                    {
//                        break;
//                    }
//                }
//
//                arrKeyToSwap[g_arrDupList[lKey][i + 1]][0] = j;
//
//                do
//                {
//                    lCost = g_arrPeople[lKey][g_arrDupList[lKey][i + 1]]
//                          - g_arrPeople[g_arrAreaList[g_arrDupList[lKey][i + 1]][lPermitted]][g_arrDupList[lKey][i + 1]];
//                    lPermitted++;
//                } while (lCost < 0);
//
//                arrKeyToSwap[g_arrDupList[lKey][i + 1]][1] = lPermitted - 1;
//
//                if (lCost > lMaxCost)
//                {
//                    lMaxCost = lCost;
//                    lIndex = i;
//                }
//            }
//
//            if (!lMaxCost)
//            {
//                for (i = 0; i < g_arrDupList[lKey][0]; i++)
//                {
//                    if (g_arrDupList[g_arrAreaList[ g_arrDupList[lKey][i + 1] ][ arrKeyToSwap[g_arrDupList[lKey][i + 1]][1] ] ][0] > 1)
//                    {
//                        lIndex = i;
//                        bDecided = Q5_TRUE;
//                        break;
//                    }
//                }
//            }
//
//            if (!bDecided)
//            {
//                for (i = 0; i < g_arrDupList[lKey][0]; i++)
//                {
//                    lPermitted = arrKeyToSwap[g_arrDupList[lKey][i + 1]][1];
//
//                    do
//                    {
//                        lPermitted++;
//                        lCost = g_arrPeople[lKey][g_arrDupList[lKey][i + 1]]
//                            - g_arrPeople[g_arrAreaList[g_arrDupList[lKey][i + 1]][lPermitted]][g_arrDupList[lKey][i + 1]];
//                    } while ((lCost < 0
//                        || g_arrDupList[g_arrAreaList[ g_arrDupList[lKey][i + 1] ][ lPermitted ] ][0])
//                        && lPermitted < lM);
//
//                    if (lPermitted != lM)
//                    {
//                        arrKeyToSwap[g_arrDupList[lKey][i + 1]][1] = lPermitted;
//                    }
//                    else
//                    {
//                        lIndex = i;
//                    }
//                }
//            }
//
//            for (i = 0; i < g_arrDupList[lKey][0]; i++)
//            {
//                if (i != lIndex)
//                {
//                    lTemp = g_arrAreaList[ g_arrDupList[lKey][i + 1] ][ arrKeyToSwap[ g_arrDupList[lKey][i + 1] ][1] ];
//                    g_arrAreaList[ g_arrDupList[lKey][i + 1] ][ arrKeyToSwap[ g_arrDupList[lKey][i + 1] ][1] ] =
//                        g_arrAreaList[ g_arrDupList[lKey][i + 1] ][ arrKeyToSwap[ g_arrDupList[lKey][i + 1] ][0] ];
//                    g_arrAreaList[ g_arrDupList[lKey][i + 1] ][ arrKeyToSwap[ g_arrDupList[lKey][i + 1] ][0] ] = lTemp;
//
//                    g_arrDupList[lTemp][0]++;
//                    g_arrDupList[lTemp][g_arrDupList[lTemp][0]] = g_arrDupList[lKey][i + 1];
//                }
//            }
//
//            lOldCnt = g_arrDupList[lKey][0];
//            g_arrDupList[lKey][0] = 1;
//
//            for (i = 0; i < lM; i++)
//            {
//                if (g_arrDupList[i][0] > 1)
//                {
//                    lDupCnt++;
//                    lTemp = GetSwapResult(lN, lM, i);
//
//                    if (lTemp > lMaxTotal)
//                    {
//                        lMaxTotal = lTemp;
//                    }
//                }
//            }
//
//            if (!lDupCnt)
//            {
//                lMaxTotal = GetTotal(lN, lM);
//            }
//
//            g_arrDupList[lKey][0] = lOldCnt;
//
//            for (i = 0; i < g_arrDupList[lKey][0]; i++)
//            {
//                if (i != lIndex)
//                {
//                    lTemp = g_arrAreaList[ g_arrDupList[lKey][i + 1] ][ arrKeyToSwap[ g_arrDupList[lKey][i + 1] ][0] ];
//                    g_arrAreaList[ g_arrDupList[lKey][i + 1] ][ arrKeyToSwap[ g_arrDupList[lKey][i + 1] ][0] ] =
//                        g_arrAreaList[ g_arrDupList[lKey][i + 1] ][ arrKeyToSwap[ g_arrDupList[lKey][i + 1] ][1] ];
//                    g_arrAreaList[ g_arrDupList[lKey][i + 1] ][ arrKeyToSwap[ g_arrDupList[lKey][i + 1] ][1] ] = lTemp;
//
//                    g_arrDupList[lTemp][0]--;
//                }
//            }
//
//            return lMaxTotal;
//        }
//
///*
//  lN is Area count
//  lM is People count
// */
//        long GetBestSolution(long lN, long lM)
//        {
//            long i, j;
//            long lDupCnt = 0;
//            long lTotal = 0;
//            long lMaxTotal = 0;
//
//            if (1 == lN)
//            {
//                for (i = 0; i < lM; i++)
//                {
//                    lTotal += g_arrPeople[i][0];
//                }
//
//                return lTotal;
//            }
//
//            for (i = 0; i < lN; i++)
//            {
//                for (j = 0; j < g_arrPermitted[i]; j++)
//                {
//                    g_arrDupList[g_arrAreaList[i][j]][0]++;
//                    g_arrDupList[g_arrAreaList[i][j]][g_arrDupList[g_arrAreaList[i][j]][0]] = i;
//                }
//            }
//
//            for (i = 0; i < lM; i++)
//            {
//                if (g_arrDupList[i][0] > 1)
//                {
//                    lDupCnt++;
//                    lTotal = GetSwapResult(lN, lM, i);
//
//                    if (lTotal > lMaxTotal)
//                    {
//                        lMaxTotal = lTotal;
//                    }
//                }
//            }
//
//            if (!lDupCnt)
//            {
//                return GetTotal(lN, lM);
//            }
//
//            return lMaxTotal;
//        }
//
//        long main(long argc, char* argv[])
//        {
//            FILE * fp = fopen(argv[1], "r");
//            char szBuf[4096], *pBuf;
//            long lN, lM;
//            long i, j;
//            long lRet;
//
//            fgets(szBuf, 4096, fp);
//            pBuf = ReadInt(szBuf, &lN);
//            pBuf = ReadInt(szBuf, &lM);
//
//            fgets(szBuf, 4096, fp);
//            pBuf = szBuf;
//
//            for (i = 0; i < lN; i++)
//            {
//                pBuf = ReadInt(pBuf, &g_arrPermitted[i]);
//            }
//
//            for (i = 0; i < lM; i++)
//            {
//                fgets(szBuf, 4096, fp);
//                pBuf = szBuf;
//
//                for (j = 0; j < lN; j++)
//                {
//                    g_arrAreaList[j][i] = i;
//                    pBuf = ReadInt(pBuf, &g_arrPeople[i][j]);
//                }
//            }
//
//            for (g_lCntSort = 0; g_lCntSort < lN; g_lCntSort++)
//            {
//                qsort(g_arrAreaList[g_lCntSort], lM, sizeof(long), compare);
//            }
//
//            fclose(fp);
//
//            /* algorithm */
//            lRet = GetBestSolution(lN, lM);
//            printf("%ld", lRet);
//
//            return 0;
//        }
